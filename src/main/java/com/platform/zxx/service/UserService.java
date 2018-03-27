package com.platform.zxx.service;

import com.platform.zxx.entity.ResourcePlusRole;
import com.platform.zxx.entity.Role;
import com.platform.zxx.entity.User;

import java.util.List;

public interface UserService {

    User getUserByName(String username);

    int regist(User user);

}
