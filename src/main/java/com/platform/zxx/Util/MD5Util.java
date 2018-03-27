package com.platform.zxx.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    //设置一个常量为盐值
    private static final String SALT = "zxx";

    public static String encode(String password){
        password = password + SALT;
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //将加盐后的密码转换为byte数组
        byte[] passwords = password.getBytes();

        byte[] md5Bytes = md5.digest(passwords);

        StringBuffer hexValue = new StringBuffer();

        for(byte b : md5Bytes){
            //%02X：以十六进制输出,2为指定的输出字段的宽度.如果位数小于2,则左端补0
            hexValue.append(String.format("%02X",b));
        }

        return hexValue.toString();
    }
}
