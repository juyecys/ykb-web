package cn.com.yikangbao.service.authority.impl;

import cn.com.yikangbao.dao.authority.AuthorityDAO;
import cn.com.yikangbao.entity.authority.Authority;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeysine on 2018/1/23.
 */
@Service("authorityService")
public class AuthorityServiceImpl extends BaseServiceImpl<Authority, Authority>{
    @Autowired
    private AuthorityDAO dao;

    @Autowired
    private void setDao(AuthorityDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
