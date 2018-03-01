package cn.com.yikangbao.api.admin.wechat;

import cn.com.yikangbao.api.common.ApiCodes;
import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.constants.AliyunOssPath;
import cn.com.yikangbao.entity.channel.Channel;
import cn.com.yikangbao.entity.channel.ChannelDTO;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.wechat.localwechatmenu.LocalWechatMenu;
import cn.com.yikangbao.entity.wechat.material.WechatMaterial;
import cn.com.yikangbao.entity.wechat.qrcode.WechatQRCode;
import cn.com.yikangbao.entity.wechat.qrcode.WechatQRCodeResult;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.exception.aliyun.oss.AliyunContentStorageException;
import cn.com.yikangbao.service.aliyun.oss.AliyunContentStorageService;
import cn.com.yikangbao.service.channel.ChannelService;
import cn.com.yikangbao.service.wechat.localMenu.LocalWechatMenuService;
import cn.com.yikangbao.service.wechat.material.WechatMaterialService;
import cn.com.yikangbao.service.wechat.menu.WechatMenuService;
import cn.com.yikangbao.service.wechat.qrcode.WechatQRCodeService;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import cn.com.yikangbao.untils.common.AliyunContentStorageUtils;
import cn.com.yikangbao.untils.wechat.WechatQRCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(value = { "/ykb/mg/private/wechat" }, produces = "application/json")
public class PrivateAdminWechatController {

    @Autowired
    private LocalWechatMenuService localWechatMenuService;

    @Autowired
    private WechatQRCodeService wechatQRCodeServiceRPC;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private AliyunContentStorageService aliyunContentStorageService;

    @Autowired
    private WechatMenuService wechatMenuServiceRPC;

    @Autowired
    private LocalWechatUserService localWechatUserService;

    @Autowired
    private WechatMaterialService wechatMaterialServiceRPC;

    private static Logger logger = LoggerFactory.getLogger(PrivateAdminWechatController.class);

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> createWechatMenu(@RequestBody LocalWechatMenu menu) {
        try {
            localWechatMenuService.createOrUpdate(menu);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResult(ApiCodes.STATUS_INVALID_PARAMETER, "微信菜单不能存在重复key"), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResult.success(menu), HttpStatus.OK);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getWechatMenu(LocalWechatMenu menu) {
        Page page = localWechatMenuService.findByConditionPage(menu);
        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> deleteWechatMenu(@RequestBody LocalWechatMenu menu) {
        if (menu.getId() == null) {
            return new ResponseEntity<>(ApiResult.error(ApiCodes.STATUS_INVALID_PARAMETER), HttpStatus.OK);
        } else {
            localWechatMenuService.deleteById(menu.getId());
        }
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }

    @RequestMapping(value = "/menu/generate", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> generateWechatMenu() {
        try {
            Boolean isSuccess = wechatMenuServiceRPC.generateWechatMenu();
            if (!isSuccess) {
                return new ResponseEntity<>(ApiResult.error(ApiCodes.STATUS_UNKNOWN_ERROR), HttpStatus.OK);
            }
        } catch (IOException e) {
            logger.error("generate wechat menu faild: {}", e);
            return new ResponseEntity<>(ApiResult.error(ApiCodes.STATUS_UNKNOWN_ERROR), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }

    @RequestMapping(value = "/qrcode", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> createOrUpdateQRCode(@RequestBody Channel channel) {
        if (channel.getId() != null) {
            channelService.update(channel);

            ChannelDTO channelDTO = new ChannelDTO();
            channelDTO.setId(channel.getId());
            channelDTO = channelService.findOneByCondition(channelDTO);
            channelDTO.setQrCodeUrl(AliyunContentStorageUtils.getFullAccessUrlForKey(channelDTO.getQrCodeUrl()));
            return new ResponseEntity<>(ApiResult.success(channelDTO), HttpStatus.OK);
        }

        WechatQRCode wechatQRCode = WechatQRCodeUtils.getForeverQRCode(channel);
        WechatQRCodeResult result = null;

        try {
            result = wechatQRCodeServiceRPC.createForverQRCode(wechatQRCode);
            InputStream inputStream = wechatQRCodeServiceRPC.getQRCode(result.getTicket());

            String savePath = AliyunOssPath.CHANNEL_QRCODE_FILEPATH;
            if (!savePath.endsWith("/")) {
                savePath += "/";
            }
            savePath = savePath + channel.getScene() + "_" + System.currentTimeMillis() + ".jpg";
            aliyunContentStorageService.store(savePath, inputStream, "image/jpg");

            channel.setTicket(result.getTicket());
            channel.setQrCodeUrl(savePath);
            channel = channelService.create(channel);
            channel.setQrCodeUrl(AliyunContentStorageUtils.getFullAccessUrlForKey(channel.getQrCodeUrl()));
        } catch (IOException e) {
            logger.error("transform wechatQrCode:{} to json faild: {}", wechatQRCode, e);
            return new ResponseEntity<>(ApiResult.error(ApiCodes.STATUS_UNKNOWN_ERROR), HttpStatus.OK);
        } catch (AliyunContentStorageException e) {
            logger.error("transfer wechatQrCode:{}, ticket:{}  to aliyun oss faild: {}", wechatQRCode, result.getTicket(), e);
            return new ResponseEntity<>(ApiResult.error(ApiCodes.STATUS_UNKNOWN_ERROR), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResult.success(channel), HttpStatus.OK);
    }

    @RequestMapping(value = "/qrcode", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getWechatQrCode(ChannelDTO channel) {
        Page<ChannelDTO> page = channelService.findByConditionPage(channel);
        for (ChannelDTO one: page.getResult()) {
            one.setQrCodeUrl(AliyunContentStorageUtils.getFullAccessUrlForKey(one.getQrCodeUrl()));
        }
        logger.info("qrcode : {}", page);
        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/qrcode/query", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getOneWechatQrCode(ChannelDTO channel) {
        List<ChannelDTO> channelDTOS = channelService.findByCondition(channel);

        for (ChannelDTO one: channelDTOS) {
            one.setQrCodeUrl(AliyunContentStorageUtils.getFullAccessUrlForKey(one.getQrCodeUrl()));
        }

        logger.info("channel : {}", channel);
        return new ResponseEntity<>(ApiResult.success(channelDTOS), HttpStatus.OK);
    }

    @RequestMapping(value = "/qrcode/user", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getWechatQrCode(LocalWechatUserDTO localWechatUserDTO) {
        Page<LocalWechatUserDTO> page = localWechatUserService.findByConditionPage(localWechatUserDTO);
        logger.info("qrcode user : {}", page);
        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/material", method = RequestMethod.POST,  produces = "application/json")
    public ResponseEntity<ApiResult> test(@RequestParam("file") MultipartFile file, @RequestParam String type) throws IOException {

        WechatMaterial wechatMaterial = wechatMaterialServiceRPC.createForeverMaterial(file, type);
        logger.info("wechat material: {}", wechatMaterial);

        return new ResponseEntity<>(ApiResult.success(wechatMaterial), HttpStatus.OK);
    }



}
