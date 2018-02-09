package cn.com.yikangbao.mongo.dao.message;

import cn.com.yikangbao.entity.message.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by jeysine on 2018/2/9.
 */
@Component
public interface MessageDAO extends MongoRepository<Message, String> {

}
