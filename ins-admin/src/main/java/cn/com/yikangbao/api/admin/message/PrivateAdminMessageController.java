package cn.com.yikangbao.api.admin.message;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.message.MessageDTO;
import cn.com.yikangbao.service.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by jeysine on 2018/2/9.
 */
@RestController
@RequestMapping(value = { "/ykb/mg/public/message" }, produces = "application/json", consumes = "application/json;")
public class PrivateAdminMessageController {
    private static Logger logger = LoggerFactory.getLogger(PrivateAdminMessageController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> createMessage(@RequestBody Message message) {
        message.setId(UUID.randomUUID().toString());
        message = messageService.createOrUpdateMessage(message);
        return new ResponseEntity<>(ApiResult.success(message), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getMessage(Message message) {
        List<Message> messageList =  messageService.findAll();
        return new ResponseEntity<>(ApiResult.success(messageList), HttpStatus.OK);
    }
}
