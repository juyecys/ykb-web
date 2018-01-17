package cn.com.yikangbao.service.authority.impl;

import cn.com.yikangbao.dao.authority.UserDao;
import cn.com.yikangbao.entitys.authority.User;
import cn.com.yikangbao.service.authority.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;
    @Override
    public User create(User entity) {
        entity.setCreatedDate(new Date());
        dao.create(entity);
        return entity;
    }

    @Override
    public User update(User entity) {
        entity.setUpdatedDate(new Date());
        dao.update(entity);
        return entity;
    }

    @Override
    public User findById(String s) {
        return dao.findById(s);
    }

    @Override
    public void deleteById(String s) {
        dao.deleteById(s);
    }

    @Override
    public Iterable<User> findAll() {
        return dao.getList();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean isExistsById(String s) {
        return dao.isExistById(s);
    }
}
