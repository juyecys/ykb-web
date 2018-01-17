package cn.com.yikangbao.service.wechat.qrcode.impl;

import cn.com.yikangbao.dao.wechat.qrcode.LocalWechatQRCodeDAO;
import cn.com.yikangbao.entity.wechat.qrcode.LocalWechatQRCode;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.wechat.qrcode.LocalWechatQRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("localWechatQRCodeService")
public class LocalWechatQRCodeServiceImpl extends BaseServiceImpl<LocalWechatQRCode, LocalWechatQRCode> implements LocalWechatQRCodeService{
    @Autowired
    private LocalWechatQRCodeDAO dao;

    @Autowired
    public void setDao(LocalWechatQRCodeDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
