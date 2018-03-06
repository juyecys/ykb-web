package cn.com.yikangbao.job.partner;

import cn.com.yikangbao.job.DistributedExclusiveTask;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("partnerTimerTasks")
@DistributedExclusiveTask("partner-timertasks")
public class PartnerTimerTasks {

	@Autowired
	private QianhaiService qianhaiService;

	@Scheduled(cron = "${partner.qianhai.order.synchronous.status}")
	public void synchronousOrderStatus() {
		qianhaiService.synchronousOrderStatus();
	}
}