package cn.com.yikangbao.service.message.impl;

import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.message.MessageDTO;
import cn.com.yikangbao.mongo.dao.message.MessageDAO;
import cn.com.yikangbao.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by jeysine on 2018/2/9.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO dao;

    @Override
    public void pushMessage(MessageDTO message) {
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
            case ARTICLE:
                break;
            case ARTICLE_LIST:
                break;
        }
    }

    @Override
    public Message createOrUpdate(Message message) {
        if (message.getId() == null) {
            message.setId(UUID.randomUUID().toString());
        }
        create(message);
        return message;
    }

    @Override
    public List<Message> findByStatusOrderBySequenceDesc(Boolean status) {
        return dao.findByStatusOrderBySequenceDesc(status);
    }

    @Override
    public List<Message> findByType(String type) {
        return dao.findByType(type);
    }

    @Override
    public Message create(Message entity) {
        return dao.save(entity);
    }

    @Override
    public List<Message> findAll() {
        return (List<Message>) dao.findAll();
    }

    @Override
    public List<Message> findAll(Sort var1) {
        return null;
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }
}
