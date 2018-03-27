package com.platform.zxx.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MyAccessDecissoinManager implements AccessDecisionManager{
    @Override
//    Authentication 为 UserDetailservice 中获取的验证信息
//    Object 包含客户端发起的请求的requset信息
//    Collection<ConfigAttribute> 为 权限资源管理器传过来的信息
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

        //1.不需要验证的情况( 写在数据库中直接放行)
        //2.验证该用户拥有所请求资源的权限
        for(ConfigAttribute cfg: collection){
            String needRole = cfg.getAttribute();
            for(GrantedAuthority grantedAuthority : authentication.getAuthorities()){
                if( needRole.equals( grantedAuthority.getAuthority() ) || needRole.equals("NONE") ){
                    return;
                }
            }
        }

        // 如果以上条件都不满足  抛出无权限异常
        System.out.println("no right");
        throw new AccessDeniedException("no right");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
