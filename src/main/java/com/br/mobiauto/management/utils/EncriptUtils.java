package com.br.mobiauto.management.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncriptUtils {

    @Autowired
    private static PasswordEncoder passwordEncoder;


    public static String encrypt(String value) {
        return passwordEncoder.encode(value);
    }
}
