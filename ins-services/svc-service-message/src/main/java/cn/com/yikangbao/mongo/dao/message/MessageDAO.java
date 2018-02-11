package cn.com.yikangbao.mongo.dao.message;

import cn.com.yikangbao.entity.message.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jeysine on 2018/2/9.
 */
@Component
public interface MessageDAO extends PagingAndSortingRepository<Message, String> {
    List<Message> findByStatusOrderBySequenceDesc(Boolean status);

    List<Message> findByType(String type);
}
