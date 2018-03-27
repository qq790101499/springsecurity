package com.platform.zxx.security;

import com.platform.zxx.Util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ServletContext application;

    @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new UserSecurityService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder( new PasswordEncoder(){

              @Override
              public String encode(CharSequence rawPassword) {
                  return MD5Util.encode((String)rawPassword);
              }

              @Override
              public boolean matches(CharSequence rawPassword, String encodedPassword) {
                  // encodedPassword 为从数据库获取的密码  rawPassword为前端输入的密码
                  System.out.println("matches验证");
                  boolean result = encodedPassword.equals(MD5Util.encode((String)rawPassword));
                  return result;

              }
          }
        ); //user Details Service验证

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/registHTML").permitAll()
                .anyRequest().permitAll() //全部放行，通过后续重写的拦截器进行管理
                //.authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .csrf().disable()
                .logout().permitAll() //注销行为任意访问
                .and()
                .sessionManagement()
                .maximumSessions(1); //只允许同时在线1位

    }
}
