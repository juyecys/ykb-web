package cn.com.yikangbao.service.message;

import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.message.MessageDTO;
import cn.com.yikangbao.service.mongo.common.BaseMongoService;

import java.util.List;

/**
 * Created by jeysine on 2018/2/9.
 */
public interface MessageService extends BaseMongoService<Message, Message>{
    void pushMessage(MessageDTO message);

    Message createOrUpdate(Message message);

    List<Message> findByStatusOrderBySequenceDesc(Boolean status);

    List<Message> findByType(String type);
}
