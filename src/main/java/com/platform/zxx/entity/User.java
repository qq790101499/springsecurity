package com.platform.zxx.entity;

import java.util.List;

public class User {
    private int userid;
    private String username;
    private String password;
    private int rolecode;
    private String brolecode;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getBrolecode() {
        return brolecode;
    }

    public void setBrolecode(String brolecode) {
        this.brolecode = brolecode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRolecode() {
        return rolecode;
    }

    public void setRolecode(int rolecode) {
        setBrolecode(Integer.toBinaryString(rolecode));
        this.rolecode = rolecode;
    }
}
