package cn.com.yikangbao.api.admin.channelgroup;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.channelgroup.ChannelGroup;
import cn.com.yikangbao.entity.channelgroup.ChannelGroupDTO;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.service.channelgroup.ChannelGroupService;
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
@RequestMapping(value = {"/ykb/mg/private/channelgroup", "/ykb/mg/public/channelgroup"}, produces = "application/json")
public class PrivateAdminChannelGroupController {
    @Autowired
    private ChannelGroupService channelGroupService;

    private static final Logger logger = LoggerFactory.getLogger(PrivateAdminChannelGroupController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> saveOrUpdateChannelGroup(@RequestBody ChannelGroup channelGroup) {
        try {
            channelGroup = channelGroupService.createOrUpdate(channelGroup);
        } catch (Exception e) {
            logger.debug("error: {}", e);
        }
        return new ResponseEntity<>(ApiResult.success(channelGroup), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getChannelGroup(ChannelGroupDTO channelGroup) {
       Page<ChannelGroupDTO> page = channelGroupService.findByConditionPage(channelGroup);
        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getAllChannelGroup(ChannelGroupDTO channelGroup) {
        List<ChannelGroupDTO> list = channelGroupService.findByCondition(channelGroup);
        return new ResponseEntity<>(ApiResult.success(list), HttpStatus.OK);
    }
}
