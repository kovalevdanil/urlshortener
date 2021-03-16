package com.martin.urlshortener.util;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {

    private static final String SHA1 = "SHA-1";

    public static String sha1(String value, int maxSize){
        try {
            MessageDigest digest = MessageDigest.getInstance(SHA1);
            digest.reset();
            digest.update(value.getBytes("utf8"));
            String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
            return sha1.length() < maxSize ? sha1 : sha1.substring(0, maxSize);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
           return null;
        }
    }

}
