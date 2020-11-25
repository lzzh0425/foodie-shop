package com.imooc.utils;

import com.imooc.utils.exception.RRException;
import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class MD5Utils {

    /**
     * @Title: MD5Utils.java
     * @Package com.imooc.utils
     * @Description: 对字符串进行md5加密
     */
    public static String getMD5Str(String strValue) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String newstr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
            return newstr;
        } catch (Exception e) {
            throw new RRException(e.getMessage());
        }
    }
}
