package com.platform.zxx.dao;

import com.platform.zxx.entity.ResourcePlusRole;
import com.platform.zxx.entity.Role;

import java.util.List;

public interface RoleDao {

    List<ResourcePlusRole> getResources();

    int insertResources(ResourcePlusRole resourcePlusRole);

    int updateResources(ResourcePlusRole resourcePlusRole);

    int deleteResources(ResourcePlusRole resourcePlusRole);


    List<Role> getRoles();

    int insertRoles(Role role);

    int updateRoles(Role role);

    int deleteRoles(Role role);

}
