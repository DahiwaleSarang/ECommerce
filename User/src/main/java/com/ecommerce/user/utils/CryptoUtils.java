package com.ecommerce.user.utils;


import org.springframework.security.crypto.bcrypt.BCrypt;


public class CryptoUtils {
    
    private static final int ROUND = 12;
    
    public static char[] secureHash(char[] plainTextPassword) {
        return BCrypt.hashpw(String.valueOf(plainTextPassword), BCrypt.gensalt(ROUND)).toCharArray();
    }
}