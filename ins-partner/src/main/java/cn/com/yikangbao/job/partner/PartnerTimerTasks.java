package cn.com.yikangbao.job.partner;

import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.entity.orderrecord.OrderRecordDTO;
import cn.com.yikangbao.entity.wechat.message.WechatTemplateMessage;
import cn.com.yikangbao.job.DistributedExclusiveTask;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import cn.com.yikangbao.untils.common.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component("partnerTimerTasks")
@DistributedExclusiveTask("partner-timer-tasks")
public class PartnerTimerTasks {

	@Autowired
	private QianhaiService qianhaiService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRecordService orderRecordService;

	@Value("${wechat.template.message.id.order.policy}")
	private String templateMessageIdByOrderNotify;

	@Scheduled(cron = "${partner.qianhai.order.synchronous.status}")
	public void synchronousOrderStatus() {
		List<OrderDTO> list = orderService.findNeedSysByStatus();
		qianhaiService.synchronousOrderStatus(list);
	}

	/**
	 * 若前海返回保单号的时间为昨晚23:00:00-23:59:59，早上0:00:00-早上7:59:59, 则在早上8:00:00，发送消息给用户
	 * @throws Exception
	 */
	@Scheduled(cron = "${timer.task.audio.course.add.people}")
	public void notifyUsersByOrder() throws Exception {
		OrderRecordDTO orderRecord = new OrderRecordDTO();
		Date todayStartTime = DateUtils.getTodayStartTime(new Date()).getTime();
		orderRecord.setCreatedDateStart(DateUtils.add(todayStartTime, Calendar.HOUR, -1));
		orderRecord.setCreatedDateEnd(DateUtils.add(todayStartTime, Calendar.HOUR, 8));
		List<OrderRecordDTO> list = orderRecordService.findNeedNotifyOrder(orderRecord);

		WechatTemplateMessage templateMessage = new WechatTemplateMessage();
		templateMessage.setTemplateId(templateMessageIdByOrderNotify);
		WechatTemplateMessage.Data data = templateMessage.new Data();
		WechatTemplateMessage.DataContent first = templateMessage.new DataContent();
		WechatTemplateMessage.DataContent keyWord1 = templateMessage.new DataContent();
		WechatTemplateMessage.DataContent keyWord2 = templateMessage.new DataContent();
		WechatTemplateMessage.DataContent keyWord3 = templateMessage.new DataContent();
		WechatTemplateMessage.DataContent remark = templateMessage.new DataContent();

		first.setValue("");

		for (OrderRecordDTO record: list) {
			templateMessage.setTouser(record.getOpenId());
		}


	}
}