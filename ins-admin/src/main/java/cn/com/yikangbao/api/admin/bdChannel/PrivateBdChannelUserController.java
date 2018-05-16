package cn.com.yikangbao.api.admin.bdChannel;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.userview.BdChannelUser;
import cn.com.yikangbao.entity.userview.UserViewDTO;
import cn.com.yikangbao.service.bdchannel.BdChannelService;
import cn.com.yikangbao.service.userview.BdChannelUserService;
import cn.com.yikangbao.service.userview.UserViewService;
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
@RequestMapping(value = {"/ykb/mg/private/bduser", "/ykb/mg/public/bduser"}, produces = "application/json")
public class PrivateBdChannelUserController {
    @Autowired
    private UserViewService userViewService;
    @Autowired
    private BdChannelUserService bdChannelUserService;

    @Autowired
    private BdChannelService bdChannelService;

    private static final Logger logger = LoggerFactory.getLogger(PrivateBdChannelUserController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> saveOrUpdateChannelGroup(@RequestBody BdChannelUser bdChannelUser) throws Exception {

        BdChannelUser user = bdChannelUserService.createOrUpdate(bdChannelUser);

        return new ResponseEntity<>(ApiResult.success(bdChannelUser), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getChannelGroup(UserViewDTO userViewDTO) {
        Page<UserViewDTO> page = userViewService.findByConditionPage(userViewDTO);

        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getAllChannelGroup(UserViewDTO userViewDTO) {
        List<UserViewDTO> list = userViewService.findByCondition(userViewDTO);
        return new ResponseEntity<>(ApiResult.success(list), HttpStatus.OK);
    }
}
