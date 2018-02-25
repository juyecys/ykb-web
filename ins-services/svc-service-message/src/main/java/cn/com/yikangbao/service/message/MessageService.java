package cn.com.yikangbao.service.message;

import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.service.mongo.common.BaseMongoService;

import java.io.IOException;
import java.util.List;

/**
 * Created by jeysine on 2018/2/9.
 */
public interface MessageService extends BaseMongoService<Message, Message>{

    Message createOrUpdate(Message message);

    List<Message> findByStatusOrderBySequence(Boolean status);

    List<Message> findByTypeAndQrCodeScene(String type, String qrCodeScene);

    List<Message> findByStatusAndTypeOrderBySequence(Boolean status, String type);

    List<Message> findByStatusAndTypeAndQrCodeSceneOrderBySequence(Boolean status, String type, String qrCodeScene);


}
