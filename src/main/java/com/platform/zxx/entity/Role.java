package com.platform.zxx.entity;

public class Role {

    private int roleid;
    private int rolecode;
    private String brolecode;
    private String rolename;


    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getBrolecode() {
        return brolecode;
    }

    public void setBrolecode(String brolecode) {
        this.brolecode = brolecode;
    }

    public int getRolecode() {
        return rolecode;
    }

    public void setRolecode(int rolecode) {
        setBrolecode(Integer.toBinaryString(rolecode));
        this.rolecode = rolecode;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
