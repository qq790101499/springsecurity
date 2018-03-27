package com.platform.zxx.entity;

public class ResourcePlusRole {
    private int resourceid;
    private String url;
    private String method;
    private String needrole;
    private String describe;

    public int getResourceid() {
        return resourceid;
    }

    public void setResourceid(int resourceid) {
        this.resourceid = resourceid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNeedrole() {
        return needrole;
    }

    public void setNeedrole(String needrole) {
        this.needrole = needrole;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
