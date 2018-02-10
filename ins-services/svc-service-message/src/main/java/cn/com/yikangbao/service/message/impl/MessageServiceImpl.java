package cn.com.yikangbao.service.message.impl;

import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.message.MessageDTO;
import cn.com.yikangbao.mongo.dao.message.MessageDAO;
import cn.com.yikangbao.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeysine on 2018/2/9.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO dao;

    @Override
    public Message createOrUpdateMessage(Message message) {
        Message.MsgTypeEnum msgTypeEnum = Message.MsgTypeEnum.getEnumByValue(message.getMsgType());
        switch (msgTypeEnum) {
            case TEXT:

                break;
            case IMAGE:
                break;
            case MUSIC:
                break;
            case VIDEO:
                break;
            case VOICE:
                break;
            case MPNEWS:
                break;
            case WXCARD:
                break;
        }
        return createOrUpdateTextMessage(message);
    }

    private Message createOrUpdateTextMessage(Message message) {

        return dao.save(message);
    }

    @Override
    public Message create(Message entity) {
        return dao.save(entity);
    }

    @Override
    public List<Message> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Message> findAll(Sort var1) {
        return null;
    }
}
