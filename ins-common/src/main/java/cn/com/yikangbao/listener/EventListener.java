package cn.com.yikangbao.listener;


import cn.com.yikangbao.event.Event;

public interface EventListener {
	public String getId();
	public void handleEvent(Event event);
}
