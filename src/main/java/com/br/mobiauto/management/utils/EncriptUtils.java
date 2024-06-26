package com.br.mobiauto.management.utils;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
public class EncriptUtils {

    private static final String UTF8 = StandardCharsets.UTF_8.displayName();
    private static String key = "0123456789abcdef0123456789abcdef";
    private static String initVector = "abcdef9876543210";

    public static String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(UTF8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(UTF8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes(UTF8));
            return Hex.encodeHexString(encrypted);
        } catch (Exception ex) {
            //TODO adicionar exception apropriada
            return null;
        }
    }

    public String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(UTF8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(UTF8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Hex.decodeHex(encrypted));

            return new String(original);
        } catch (Exception ex) {
            //TODO adicionar exception apropriada
            return null;
        }
    }
}
