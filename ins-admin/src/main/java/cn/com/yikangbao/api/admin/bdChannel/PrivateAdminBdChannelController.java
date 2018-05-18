package cn.com.yikangbao.api.admin.bdChannel;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.bdchannel.BdChannel;
import cn.com.yikangbao.entity.bdchannel.BdChannelDTO;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.service.aliyun.oss.AliyunContentStorageService;
import cn.com.yikangbao.service.bdchannel.BdChannelService;
import cn.com.yikangbao.untils.common.AliyunContentStorageUtils;
import cn.com.yikangbao.utils.common.QRCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jeysine on 2018/2/21.
 */
@RestController
@RequestMapping(value = {"/ykb/mg/private/bdchannel", "/ykb/mg/public/bdchannel"}, produces = "application/json")
public class PrivateAdminBdChannelController {
    @Autowired
    private BdChannelService bdChannelService;
    @Autowired
    AliyunContentStorageService aliyunContentStorageService;
    private static final Logger logger = LoggerFactory.getLogger(PrivateAdminBdChannelController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> saveOrUpdateChannelGroup(@RequestBody BdChannel bdChannel) throws Exception {

        String url = bdChannel.getQrCodeUrl();

        String savePath = "bdchannel_qrcode";
        if (!savePath.endsWith("/")) {
            savePath += "/";
        }
        savePath = savePath + bdChannel.getChannelsCode() + "_" + System.currentTimeMillis() + ".jpg";

        if(bdChannel.getId()==null || bdChannel.getId().length() == 0) {
            if (bdChannelService.getBdChannelByCode(bdChannel.getChannelsCode()) != null) {
                return new ResponseEntity<>(new ApiResult(6001, "已经存在相同的编码了！", bdChannel), HttpStatus.OK);
            }

            aliyunContentStorageService.store(savePath, QRCodeUtil.EncodeUrlToInputStream(url), "image/jpg");
            bdChannel.setQrCodeUrl(AliyunContentStorageUtils.getFullAccessUrlForKey(savePath));
        } else {
            bdChannel.setChannelsCode(null);
            bdChannel.setQrCodeUrl(null);
        }
        bdChannel = bdChannelService.createOrUpdate(bdChannel);

        return new ResponseEntity<>(ApiResult.success(bdChannel), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getChannelGroup(BdChannelDTO bdChannelDTO) {
        Page<BdChannelDTO> page = bdChannelService.findByConditionPage(bdChannelDTO);

        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getAllChannelGroup(BdChannelDTO bdChannelDTO) {
        List<BdChannelDTO> list = bdChannelService.findByCondition(bdChannelDTO);
        return new ResponseEntity<>(ApiResult.success(list), HttpStatus.OK);
    }
}
