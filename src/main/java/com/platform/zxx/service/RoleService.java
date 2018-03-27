package com.platform.zxx.service;

import com.platform.zxx.entity.ResourcePlusRole;
import com.platform.zxx.entity.Role;

import java.util.List;

public interface RoleService {

    List<ResourcePlusRole> getResources();

    void insertResources(ResourcePlusRole resourcePlusRole);

    void updateResources(ResourcePlusRole resourcePlusRole);

    void deleteResources(ResourcePlusRole resourcePlusRole);


    List<Role> getRoles();

    void insertRoles(Role role);

    void updateRoles(Role role);

    void deleteRoles(Role role);

}
