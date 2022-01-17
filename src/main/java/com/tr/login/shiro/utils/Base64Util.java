package com.tr.login.shiro.utils;

import org.apache.shiro.codec.Base64;
import org.springframework.util.Base64Utils;

/**
 * Base64 工具类
 *
 * @author rtao
 * @date 2022/1/6 10:56
 */
public class Base64Util {

    public static void main(String[] args) {
        String password = "123456";
        String ciphertext = encodeBase64(password);
        System.out.println("密文：" + ciphertext);

        String text = decodeBase64(ciphertext);
        System.out.println("明文：" + text);
    }

    /**
     * base64 加密
     * @param password
     * @return
     */
    public static String encodeBase64(String password) {
        return Base64.encodeToString(password.getBytes());
    }

    /**
     * base64 解密
     * @param password
     * @return
     */
    public static String decodeBase64(String password) {
        return Base64.decodeToString(password.getBytes());
    }

}
