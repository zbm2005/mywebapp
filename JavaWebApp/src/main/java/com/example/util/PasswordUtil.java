package com.example.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public final class PasswordUtil {

    private static final SecureRandom RANDOM = new SecureRandom();

    private PasswordUtil() {
    }

    public static String newSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return toHex(salt);
    }

    public static String hashPassword(String password, String salt) {
        return toHex(hashBytes(password, salt));
    }

    public static boolean matches(String password, String salt, String expectedHash) {
        return hashPassword(password, salt).equals(expectedHash);
    }

    private static byte[] hashBytes(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(salt.getBytes(StandardCharsets.UTF_8));
            digest.update(password.getBytes(StandardCharsets.UTF_8));
            return digest.digest();
        } catch (Exception ex) {
            throw new IllegalStateException("Unable to hash password", ex);
        }
    }

    private static String toHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
