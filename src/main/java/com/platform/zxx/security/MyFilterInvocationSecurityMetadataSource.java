package com.platform.zxx.security;


import com.platform.zxx.dao.UserDao;
import com.platform.zxx.entity.ResourcePlusRole;
import com.platform.zxx.service.RoleService;
import com.platform.zxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private RoleService roleService;

    List<ResourcePlusRole> resourcePlusRoles = null;

    public void getResourcePlusRole(){
        resourcePlusRoles = roleService.getResources();
    }

    //最新的security5中，该方法如果返回是null或者 size=0 会直接放行
    //之前的版本任然需要进入decide的方法去判定
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        System.out.println(request.getRequestURI());
        Collection<ConfigAttribute> configAttributes = new ArrayList<>();

        if (resourcePlusRoles == null){
            getResourcePlusRole();
        }

        // AntPathRequestMatcher 用来判断 某个具体的url 是否 和 /** 这种通配可以匹配，同时也可以匹配方法
        AntPathRequestMatcher matcher;

        for(ResourcePlusRole rpr : resourcePlusRoles){
            //如果数据库中方法是ALL，则不需要再去比较request中的方法
            if("ALL".equals(rpr.getMethod())){
                matcher = new AntPathRequestMatcher(rpr.getUrl());
            }else {
                matcher = new AntPathRequestMatcher(rpr.getUrl(),rpr.getMethod());
            }

            if(matcher.matches(request)){
                configAttributes.add(new SecurityConfig(rpr.getNeedrole()));
            }
        }

        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
