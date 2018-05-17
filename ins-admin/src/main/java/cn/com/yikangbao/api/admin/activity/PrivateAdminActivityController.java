package cn.com.yikangbao.api.admin.activity;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.activity.Activity;
import cn.com.yikangbao.entity.activity.ActivityDTO;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.service.activity.ActivityService;
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
@RequestMapping(value = {"/ykb/mg/private/activity", "/ykb/mg/public/activity"}, produces = "application/json")
public class PrivateAdminActivityController {
    @Autowired
    private ActivityService activityService;

    private static final Logger logger = LoggerFactory.getLogger(PrivateAdminActivityController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> saveOrUpdateChannelGroup(@RequestBody Activity activity) throws Exception {
        Activity temp = activityService.selectByName(activity.getName());

        if (temp != null)
            activity.setId(temp.getId());
        activityService.createOrUpdate(activity);
        return new ResponseEntity<>(ApiResult.success(activity), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getChannelGroup(ActivityDTO activityDTO) {
        Page<ActivityDTO> page = activityService.findByConditionPage(activityDTO);

        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getAllChannelGroup(ActivityDTO activityDTO) {
        List<ActivityDTO> list = activityService.findByCondition(activityDTO);
        return new ResponseEntity<>(ApiResult.success(list), HttpStatus.OK);
    }
}
