package cn.com.yikangbao.job.partner;

import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.job.DistributedExclusiveTask;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("partnerTimerTasks")
@DistributedExclusiveTask("partner-timertasks")
public class PartnerTimerTasks {

	@Autowired
	private QianhaiService qianhaiService;

	@Autowired
	private OrderService orderService;

	@Scheduled(cron = "${partner.qianhai.order.synchronous.status}")
	public void synchronousOrderStatus() {
		List<OrderDTO> list = orderService.findNeedSysByStatus();
		qianhaiService.synchronousOrderStatus(list);
	}
}