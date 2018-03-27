package com.platform.zxx.service;

import com.platform.zxx.Util.MD5Util;
import com.platform.zxx.dao.UserDao;
import com.platform.zxx.entity.ResourcePlusRole;
import com.platform.zxx.entity.Role;
import com.platform.zxx.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserByName(String username) {

        return userDao.getUserByName(username);

    }

    @Override
    public int regist(User user) {
        //将密码加密
        user.setPassword(MD5Util.encode(user.getPassword()));
        return userDao.regist(user);
    }

}
