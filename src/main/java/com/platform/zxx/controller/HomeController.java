package com.platform.zxx.controller;

import com.platform.zxx.entity.User;
import com.platform.zxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class HomeController {
    @Autowired
    ServletContext application;
    @Autowired
    UserService userService;

    //登录页面
    @RequestMapping("/login")
    public String login (HttpServletRequest request){
        return "login";
    }

    //注销
    @RequestMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "/";
    }

    //默认主页
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    //查找用户名是否存在
    @ResponseBody
    @RequestMapping(value = "username",method = RequestMethod.GET)
    public Boolean userIsExist(String username){
        User user = userService.getUserByName(username);
        if(user == null){
            return true;
        }else {
            return false;
        }
    }

    //注册
    @ResponseBody
    @RequestMapping(value = "regist",method = RequestMethod.POST)
    public String regist(User user){
        if(userService.getUserByName(user.getUsername()) == null){
            userService.regist(user);
            return "注册成功";
        }else {
            return "用户名已存在";
        }

    }

    //注册界面
    @RequestMapping("/registHTML")
    public String register(){
        return "register";
    }

}
