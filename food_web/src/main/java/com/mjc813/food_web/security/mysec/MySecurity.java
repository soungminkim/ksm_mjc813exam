package com.mjc813.food_web.security.mysec;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Slf4j
@Component
public class MySecurity {

    private static final String keyString = "Mjc813classThisisMyKey0123456789"; // key는 32글자
    private static final String ivString = "QWEASDOIEUSKSThi";  // iv 는 16글자

    public static String generateEncryptionKey() {
        byte[] key = keyString.getBytes();
        return Base64.getEncoder().encodeToString(key);
    }
    public static String generateIVKey() {
        byte[] iv = ivString.getBytes();
        return Base64.getEncoder().encodeToString(iv);
    }

    public String encode(String input) {
        if ( input == null ) {
            return "";
        }
        String result = this.encrypt(generateEncryptionKey(), generateIVKey(), input);
        return result;
    }

    // Encryption
    private String encrypt(String key, String iv, String plainText) {
        // AES-256 Encryption
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            byte[] decodedIV = Base64.getDecoder().decode(iv);

            SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(decodedIV);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

            return Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception e) {
            log.error(e.toString());
        }
        return "";
    }

    public String decode(String input) {
        if ( input == null ) {
            return "";
        }
        String result = this.decrypt(generateEncryptionKey(), generateIVKey(), input);
        return result;
    }

    // Decryption
    private String decrypt(String key, String iv, String encryptedText) {
        // AES-256 Decryption
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            byte[] decodedIV = Base64.getDecoder().decode(iv);
            byte[] decodedEncryptedText = Base64.getDecoder().decode(encryptedText);

            SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(decodedIV);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] decryptedBytes = cipher.doFinal(decodedEncryptedText);

            return new String(decryptedBytes);

        } catch (Exception e) {
            log.error(e.toString());
        }
        return "";
    }
}
