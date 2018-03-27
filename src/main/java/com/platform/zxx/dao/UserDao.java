package com.platform.zxx.dao;

import com.platform.zxx.entity.ResourcePlusRole;
import com.platform.zxx.entity.Role;
import com.platform.zxx.entity.User;

import java.util.List;

public interface UserDao {

    User getUserByName(String username);

    int regist(User user);

}
