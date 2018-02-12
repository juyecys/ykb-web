package cn.com.yikangbao.api.admin.message;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.message.MessageDTO;
import cn.com.yikangbao.entity.wechat.qrcode.LocalWechatQRCode;
import cn.com.yikangbao.service.message.MessageService;
import cn.com.yikangbao.service.wechat.qrcode.LocalWechatQRCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by jeysine on 2018/2/9.
 */
@RestController
@RequestMapping(value = { "/ykb/mg/private/message", "/ykb/mg/public/message" }, produces = "application/json")
public class PrivateAdminMessageController {
    private static Logger logger = LoggerFactory.getLogger(PrivateAdminMessageController.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    private LocalWechatQRCodeService localWechatQRCodeService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> createMessage(@RequestBody Message message) {
        message = messageService.createOrUpdate(message);
        return new ResponseEntity<>(ApiResult.success(message), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getMessage(Message message) {
        List<Message> messageList =  messageService.findByTypeAndQrCodeScene(message.getType(), message.getQrCodeScene());
        return new ResponseEntity<>(ApiResult.success(messageList), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> deleteMessage(@RequestBody Message message) {
        messageService.delete(message.getId());
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> sendMessage(@RequestBody MessageDTO message) throws IOException {
        if (Message.TypeEnum.CHANNEL.name().equals(message.getType())) {
            LocalWechatQRCode localWechatQRCode = new LocalWechatQRCode();
            localWechatQRCode.setScene(message.getQrCodeScene());
            localWechatQRCode = localWechatQRCodeService.findOneByCondition(localWechatQRCode);
            if (localWechatQRCode.getSendChannelMessage()) {
                messageService.pushChannelsMessage(message.getOpenId(), message.getQrCodeScene());
            }
            if (localWechatQRCode.getSendSubscribeMessage()) {
                messageService.pushSubscribeMessage(message.getOpenId());
            }

        } else if(Message.TypeEnum.SUBSCRIBE.name().equals(message.getType())){
            messageService.pushSubscribeMessage(message.getOpenId());
        }
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }
}
