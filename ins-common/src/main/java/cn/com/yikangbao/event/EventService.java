package cn.com.yikangbao.event;


import cn.com.yikangbao.listener.EventListener;

public interface EventService {
	public void publish(Event event) throws EventServiceException;
	public void subscribe(String eventType, EventListener listener) throws EventServiceException;
}
