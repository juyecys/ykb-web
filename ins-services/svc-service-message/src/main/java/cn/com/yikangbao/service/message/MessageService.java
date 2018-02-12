package cn.com.yikangbao.service.message;

import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.service.mongo.common.BaseMongoService;

import java.io.IOException;
import java.util.List;

/**
 * Created by jeysine on 2018/2/9.
 */
public interface MessageService extends BaseMongoService<Message, Message>{
    void pushMessage(String openId, Message message) throws IOException;

    void pushMessageList(String openId, List<Message> message) throws IOException;

    void pushSubscribeMessage(String openid) throws IOException;

    void pushChannelsMessage(String openId, String qrCodeScene) throws IOException;

    Message createOrUpdate(Message message);

    List<Message> findByStatusOrderBySequence(Boolean status);

    List<Message> findByTypeAndQrCodeScene(String type, String qrCodeScene);

    List<Message> findByStatusAndTypeOrderBySequence(Boolean status, String type);

    List<Message> findByStatusAndTypeAndQrCodeSceneOrderBySequence(Boolean status, String type, String qrCodeScene);


}
