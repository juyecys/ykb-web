package cn.com.yikangbao.service.wechat.qrcode;

import cn.com.yikangbao.entity.wechat.qrcode.WechatQRCode;
import cn.com.yikangbao.entity.wechat.qrcode.WechatQRCodeResult;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jeysine on 2018/1/23.
 */
public interface WechatQRCodeService {
    WechatQRCodeResult createForverQRCode(WechatQRCode qrCode) throws IOException;
    WechatQRCodeResult createTemporaryQRCode(WechatQRCode qrCode) throws IOException;
    WechatQRCodeResult createQRCode(WechatQRCode qrCode) throws IOException;

    InputStream getQRCode(String ticket);

}
