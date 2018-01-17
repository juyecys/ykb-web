package cn.com.yikangbao.service.user.impl;


import cn.com.yikangbao.dao.userrole.UserRoleDAO;
import cn.com.yikangbao.entity.user.User;
import cn.com.yikangbao.entity.user.UserDTO;
import cn.com.yikangbao.entity.userrole.UserRoleDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import cn.com.yikangbao.dao.user.UserDAO;
import cn.com.yikangbao.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/17.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, UserDTO> implements UserService {
    @Autowired
    private UserDAO dao;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    public void setDao(UserDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setName(username);
        user = dao.findOneByCondition(user);

        UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setUserName(username);
        List<UserRoleDTO> userRoleList = userRoleDAO.findByCondition(userRoleDTO);
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        for (UserRoleDTO userRole: userRoleList) {
            list.add(new SimpleGrantedAuthority(userRole.getRoleCode()));
        }
        user.setGrantedAuthorities(list);
        return user;
    }

    @Override
    public User findOneByCondition(User user) {
        return dao.findOneByCondition(user);
    }
}
