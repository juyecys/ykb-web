package cn.com.yikangbao.listener;


import cn.com.yikangbao.entity.common.Event;

public interface EventListener {
	public String getId();
	public void handleEvent(Event event);
}
