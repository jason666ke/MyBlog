package com.lou.springboot.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SystemUtil {

    private SystemUtil() {

    }

    /**
     * Generate session token to maintain user login status
     * after login or register successfully
     * @param src: now() + user.id + random(4)
     * @return
     */
    public static String genToken(String src) {
        if (null == src || src.isEmpty()) return null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(src.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
