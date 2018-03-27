package com.platform.zxx.controller;

import com.platform.zxx.entity.ResourcePlusRole;
import com.platform.zxx.entity.Role;
import com.platform.zxx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/resources",method = RequestMethod.GET)
    public List<ResourcePlusRole> getResources(){
        System.out.println("获取资源");
        return roleService.getResources();
    }

    @RequestMapping(value = "/resources",method = RequestMethod.POST)
    public void insertResources(ResourcePlusRole resourcePlusRole){
        roleService.insertResources(resourcePlusRole);
    }

    @RequestMapping(value = "/resources",method = RequestMethod.PUT)
    public void updateResources(ResourcePlusRole resourcePlusRole){
        roleService.updateResources(resourcePlusRole);
    }

    @RequestMapping(value = "/resources",method = RequestMethod.DELETE)
    public void deleteResources(ResourcePlusRole resourcePlusRole){
        roleService.deleteResources(resourcePlusRole);
    }


    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @RequestMapping(value = "/roles",method = RequestMethod.POST)
    public void insertRoles(Role role){
        roleService.insertRoles(role);
    }

    @RequestMapping(value = "/roles",method = RequestMethod.PUT)
    public void updateRoles(Role role){
        roleService.updateRoles(role);
    }

    @RequestMapping(value = "/roles",method = RequestMethod.DELETE)
    public void deleteRoles(Role role){
        roleService.deleteRoles(role);
    }
}
