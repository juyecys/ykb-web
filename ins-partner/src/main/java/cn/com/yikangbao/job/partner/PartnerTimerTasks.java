package cn.com.yikangbao.job.partner;

import cn.com.yikangbao.config.partner.PartnerSecretKeyConfig;
import cn.com.yikangbao.config.partner.PartnerUrlConfig;
import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.job.DistributedExclusiveTask;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import cn.com.yikangbao.untils.common.MapUtils;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import cn.com.yikangbao.utils.partner.PartnerConvertUtils;
import cn.com.yikangbao.utils.partner.PartnerSignUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

	private static final ObjectMapper mapper = new ObjectMapper();

	@Scheduled(cron = "0 0/1 * * * ?")
	public void synchronousOrderStatus() {
		List<OrderDTO> orders =  orderService.findNeedSysByStatus();
		logger.info("need synchronous order: {}", orders);
		Order newOrder = null;
		OrderRecord orderRecord = null;
		if (!orders.isEmpty()) {
			for (OrderDTO order: orders) {
				try {
					HashMap<String, Object> data = MapUtils.getMap(order, OrderDTO.class);
					String sign = PartnerSignUtils.getSign(data, PartnerSecretKeyConfig.getQianhaiSecretKeyFor());
					data.put("sign", sign);
					String dataJson = mapper.writeValueAsString(data);
					String url = PartnerUrlConfig.getFullUrl(
							PartnerUrlConfig.getQianhaiServerUrl(), PartnerUrlConfig.getQianhaiOrderUrl());
					String resultJson = OkHttpUtils.postString().url(url).content(dataJson).build().execute().body().string();
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