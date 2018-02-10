package cn.com.yikangbao.job.wechat;

import cn.com.yikangbao.entity.wechat.user.WechatUser;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.job.DistributedExclusiveTask;
import cn.com.yikangbao.service.wechat.user.WechatUserService;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component("partnerTimerTasks")
@DistributedExclusiveTask("wechat-timertasks")
public class WechatTimerTasks {
    @Autowired
    private WechatUserService wechatUserService;

    @Autowired
    private LocalWechatUserService localWechatUserService;

    private Logger logger = LoggerFactory.getLogger(WechatTimerTasks.class);

    @Scheduled(cron = "0 0/1 * * * ?")
    public void getUserInfo() throws IOException {
        List<LocalWechatUserDTO> localWechatUserDTOList = localWechatUserService.findByCondition(new LocalWechatUserDTO());
        if (!localWechatUserDTOList.isEmpty()) {
            List<String> openIds = new LinkedList<>();
            for (LocalWechatUserDTO one : localWechatUserDTOList) {
                openIds.add(one.getOpenId());
            }
            List<WechatUser> wechatUserList = wechatUserService.getWechatUserInfoList(openIds);
            logger.info("wechatUserList: {}", wechatUserList);
        }

    }
}
