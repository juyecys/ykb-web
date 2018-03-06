package cn.com.yikangbao.job.partner;

import cn.com.yikangbao.config.partner.PartnerSecretKeyConfig;
import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.job.DistributedExclusiveTask;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import cn.com.yikangbao.untils.common.DateUtils;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import cn.com.yikangbao.utils.partner.PartnerConvertUtils;
import cn.com.yikangbao.utils.partner.PartnerSignUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component("partnerTimerTasks")
@DistributedExclusiveTask("partner-timertasks")
public class PartnerTimerTasks {


	private static Logger logger = LoggerFactory.getLogger(PartnerTimerTasks.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRecordService orderRecordService;

	@Value("${qianhai.order.get.status}")
	private String qianhaiOrderStatusUrl;

	private static final ObjectMapper mapper = new ObjectMapper();

	@Scheduled(cron = "${partner.qianhai.order.synchronous.status}")
	public void synchronousOrderStatus() {
		List<OrderDTO> orders =  orderService.findNeedSysByStatus();
		logger.info("need synchronous order: {}", orders);
		Order newOrder = null;
		OrderRecord orderRecord = null;
		HashMap<String, Object> data = new HashMap<>();
		if (!orders.isEmpty()) {
			for (OrderDTO order: orders) {
				try {
					data.put("orderId", order.getOrderNumber());
					data.put("reqTime", DateUtils.format(new Date(), "yyyyMMddHHmmss"));
					String sign = PartnerSignUtils.getSign(data, PartnerSecretKeyConfig.getQianhaiSecretKeyFor());
					data.put("sign", sign);
					String dataJson = mapper.writeValueAsString(data);
					logger.debug("start to synchronous qianhai order status: {}", dataJson);
					String resultJson = OkHttpUtils.postString().url(qianhaiOrderStatusUrl).content(dataJson).build().execute().body().string();
					logger.debug("synchronous qianhai order status result: {}", resultJson);
					HashMap resultMap = mapper.readValue(resultJson, HashMap.class);
					newOrder = PartnerConvertUtils.convertOrder(resultMap);
					if (!order.getStatus().equals(newOrder.getStatus())) {
						orderService.synchronousOrderStatus(newOrder);
						orderRecord = new OrderRecord();
						orderRecord.setOrderNumber(newOrder.getOrderNumber());
						orderRecord.setStatus(newOrder.getStatus());
						orderRecordService.createOrUpdate(orderRecord);
					}
				} catch (Exception e) {
					logger.error("", e);
				}

			}

		}

	}
}