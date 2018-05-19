package cn.com.yikangbao.api.wp.bdchannel;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.config.common.WechatContextHolder;
import cn.com.yikangbao.entity.bdchannel.BdChannel;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.userview.BdChannelUser;
import cn.com.yikangbao.entity.userview.UserViewDTO;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.activity.ActivityService;
import cn.com.yikangbao.service.bdchannel.BdChannelService;
import cn.com.yikangbao.service.userview.BdChannelUserService;
import cn.com.yikangbao.service.userview.UserViewService;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import cn.com.yikangbao.utils.common.SendmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by jeysine on 2018/2/21.
 */
@RestController
@RequestMapping(value = {"/ykb/wp/private/bduser", "/ykb/wp/public/bduser"}, produces = "application/json")
public class PrivateBdChannelUserController {
    @Autowired
    private UserViewService userViewService;
    @Autowired
    private BdChannelUserService bdChannelUserService;

    @Autowired
    private BdChannelService bdChannelService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private LocalWechatUserService wechatUserService;

    private static final Logger logger = LoggerFactory.getLogger(PrivateBdChannelUserController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> saveOrUpdateChannelGroup(@RequestBody BdChannelUser user) throws Exception {

        BdChannel bdChannel = bdChannelService.getBdChannelByCode(user.getBdChannelId());

        if (bdChannel != null) {
            user.setBdChannelId(bdChannel.getId());
        } else {
            user.setBdChannelId("");
        }

        String weixinId = WechatContextHolder.getUserId() == null ? null : WechatContextHolder.getUserId().toString();
        String nick_name = WechatContextHolder.getNickName();
        user.setWeixinId(weixinId);
        user.setNickName(nick_name);
        logger.info("weixin:" + weixinId);
        logger.info("nick_name:" + nick_name);
        logger.info("getMobile:" + user.getMobile());


        if (bdChannelUserService.exists(user.getMobile()) > 0) {
            logger.info("bdChannelUserService.exists(user.getMobile()");
            return new ResponseEntity<>(new ApiResult(6001, "十分钟内不能重复提交", "手機號重複"), HttpStatus.OK);
        }


        if (weixinId != null && weixinId.length() > 0 && bdChannelUserService.existsUserId(weixinId) > 0) {
            logger.info("bdChannelUserService.existsUserId(weixinId) ");
            return new ResponseEntity<>(new ApiResult(6001, "十分钟内不能重复提交", "手機號重複"), HttpStatus.OK);
        }

        bdChannelUserService.createOrUpdate(user);

        //发送email
        String nickName="";
        String headImg="";
        String email = activityService.selectByName("bdChannel").getEmail();
        List<String> receiveList = Arrays.asList(email.split(";"));
        if (weixinId != null) {
            LocalWechatUserDTO wechatUserDTO = new LocalWechatUserDTO();
            wechatUserDTO.setId(weixinId);
            wechatUserDTO = wechatUserService.findOneByCondition(wechatUserDTO);
            if(wechatUserDTO!=null) {
                nickName = wechatUserDTO.getNickName();
                headImg = wechatUserDTO.getHeadImgUrl();
            }

        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
        Date time = user.getUpdatedDate();

        Date birthday = user.getBirthday();
        int gender = user.getGender();
        String realGender = gender == 0 ? "保密" : gender == 1 ? "男" : "女";
        String mobile = user.getMobile();
        String channel = bdChannel == null ? "" : bdChannel.getChannels();
        String bd = bdChannel == null ? "" : bdChannel.getBd();
        String head = "试管婴儿保险分销--投保意向";
        String content = "<p>微信昵称：" + nickName + "<p/>" +
                "<img src=\"" + headImg + "\"/>" +
                "<p>姓名：" + user.getName() + "</p>" +
                "<p>出生日期：" + sdf.format(birthday) + "</p>" +
                "<p>性别：" + realGender + "</p>" +
                "<p>手机号：" + mobile + "</p>" +
                "<p>渠道：" + channel + "</p>" +
                "<p>BD：" + bd + "</p>" +
                "<p>提交资料时间：" + sdf.format(time) + "</p>";

        new Thread(() -> {
            try {
                SendmailUtil util = new SendmailUtil();
                util.doSendHtmlEmail(head, content, receiveList);
            } catch (MessagingException e) {
                logger.info("", e);
            }

        }).run();
        return new ResponseEntity<>(ApiResult.success(user), HttpStatus.OK);
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
