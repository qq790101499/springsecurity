package com.platform.zxx.security;

import com.platform.zxx.entity.Role;
import com.platform.zxx.entity.User;
import com.platform.zxx.service.RoleService;
import com.platform.zxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    private List<Role> roles = null;

    public void readRoleInfo(){
        roles = null;
        System.out.println("加载权限信息");
        roles = roleService.getRoles();
    }

    @Override
    //springsercurity 登录时，使用此方法根据用户名来拉取信息
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByName(username);
        //用户不存在的情况
        if(user != null){
            // 如果内存内没有roles信息，则重新到数据库中读取
            if(roles == null){
                readRoleInfo();
            }

            int roleCode = user.getRolecode();

            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for(int i = 0 ; i < roles.size(); i++){
                // 通过user的权限代码和权限表比较，判定具有什么权限
                if((roleCode & roles.get(i).getRolecode()) != 0){
                    System.out.println(roles.get(i).getRolename());
                    authorities.add(new SimpleGrantedAuthority(roles.get(i).getRolename()));
                }
            }
            //根据权限代码来判断用户具有什么权限
            //System.out.println(user.getUsername()+"   "+user.getPassword());

            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
        }else{
            //抛出用户不存在异常
            throw new UsernameNotFoundException("用户不存在");
        }


    }
}
