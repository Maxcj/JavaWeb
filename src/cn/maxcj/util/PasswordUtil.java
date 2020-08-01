package cn.maxcj.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author maxcj
 */
public class PasswordUtil {

    public static String encPassword(String password) {
        MessageDigest md5 = null;
        byte[] digest = null;
        try {
            md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, digest).toString(16);
    }

}
