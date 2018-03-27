package com.platform.zxx.service;

import com.platform.zxx.dao.RoleDao;
import com.platform.zxx.entity.ResourcePlusRole;
import com.platform.zxx.entity.Role;
import com.platform.zxx.security.MyFilterInvocationSecurityMetadataSource;
import com.platform.zxx.security.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleDao roleDao;

    @Autowired
    MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;

    @Autowired
    UserSecurityService userSecurityService;

    @Override
    public List<ResourcePlusRole> getResources() {
        return roleDao.getResources();
    }

    @Override
    public void insertResources(ResourcePlusRole resourcePlusRole) {
        roleDao.insertResources(resourcePlusRole);
        myFilterInvocationSecurityMetadataSource.getResourcePlusRole();
    }

    @Override
    public void updateResources(ResourcePlusRole resourcePlusRole) {
        roleDao.updateResources(resourcePlusRole);
        myFilterInvocationSecurityMetadataSource.getResourcePlusRole();
    }

    @Override
    public void deleteResources(ResourcePlusRole resourcePlusRole) {
        roleDao.deleteResources(resourcePlusRole);
        myFilterInvocationSecurityMetadataSource.getResourcePlusRole();
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public void insertRoles(Role role) {
        roleDao.insertRoles(role);
        userSecurityService.readRoleInfo();
    }

    @Override
    public void updateRoles(Role role) {
        roleDao.updateRoles(role);
        userSecurityService.readRoleInfo();
    }

    @Override
    public void deleteRoles(Role role) {
        roleDao.deleteRoles(role);
        userSecurityService.readRoleInfo();
    }
}
