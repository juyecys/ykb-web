package cn.com.yikangbao.api.admin.wechatuser;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import cn.com.yikangbao.untils.common.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = { "/ykb/mg/private/user","/ykb/mg/public/user" }, produces = "application/json")
public class PrivateAdminWechatUserController {
    @Autowired
    private LocalWechatUserService localWechatUserService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getUser(@RequestParam(value = "createdDateEnd", required = false) String createdDateEnd
            ,@RequestParam(value = "createdDateStart", required = false) String createdDateStart
            ,@RequestParam(value = "channels", required = false) String channels
            ,@RequestParam(value = "channelGroupName", required = false) String channelGroupName
            ,@RequestParam(value = "province", required = false) String province
            ,@RequestParam(value = "city", required = false) String city) {
        LocalWechatUserDTO wechatUser = new LocalWechatUserDTO();
        wechatUser.setChannels(channels);
        wechatUser.setChannelGroupName(channelGroupName);
        wechatUser.setProvince(province);
        wechatUser.setCity(city);
        if (!createdDateStart.isEmpty()) {
            wechatUser.setCreatedDateStart(DateUtils.stringToDate(createdDateStart));
            if (createdDateEnd.isEmpty()) {
                wechatUser.setCreatedDateEnd(new Date());
            }
        }
        if (!createdDateEnd.isEmpty()) {
            wechatUser.setCreatedDateEnd(DateUtils.stringToDate(createdDateEnd));
            if (createdDateStart.isEmpty()) {
                wechatUser.setCreatedDateStart(new Date());
            }
        }

        List<LocalWechatUserDTO> wechatUserList =  localWechatUserService.findByCondition(wechatUser);
        return new ResponseEntity<>(ApiResult.success(wechatUserList), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getUserPage(LocalWechatUserDTO wechatUser) {
        Page<LocalWechatUserDTO> wechatUserList =  localWechatUserService.findByConditionPage(wechatUser);
        return new ResponseEntity<>(ApiResult.success(wechatUserList), HttpStatus.OK);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> countUsers(LocalWechatUserDTO wechatUser) {
        Integer count =  localWechatUserService.countUsers(wechatUser);
        if (count == null) {
            count = 0;
        }
        return new ResponseEntity<>(ApiResult.success(count), HttpStatus.OK);
    }
}
