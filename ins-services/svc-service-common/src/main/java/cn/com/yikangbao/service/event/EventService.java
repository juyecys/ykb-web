package cn.com.yikangbao.service.event;


import cn.com.yikangbao.entity.common.Event;
import cn.com.yikangbao.listener.EventListener;

public interface EventService {
	public void publish(Event event) throws EventServiceException;
	public void subscribe(String eventType, EventListener listener) throws EventServiceException;
}
