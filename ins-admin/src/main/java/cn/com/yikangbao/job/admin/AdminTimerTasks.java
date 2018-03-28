package cn.com.yikangbao.job.admin;

import cn.com.yikangbao.job.DistributedExclusiveTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("adminTimerTasks")
@DistributedExclusiveTask("admin-timer-tasks")
public class AdminTimerTasks {

    private Logger logger = LoggerFactory.getLogger(AdminTimerTasks.class);

}
