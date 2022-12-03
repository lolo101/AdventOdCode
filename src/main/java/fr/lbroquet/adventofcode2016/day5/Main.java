package fr.lbroquet.adventofcode2016.day5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    private static final String INPUT = "ffykfhsq";
    private static final MessageDigest MD;
    static {
        try {
            MD = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            throw new java.lang.ExceptionInInitializerError(ex);
        }
    }

    public static void main(String... args) {
        method1();
        System.out.println("--------");
        method2();
    }

    private static void method1() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; password.length() < 8; ++i) {
            byte[] indexedInput = (INPUT + i).getBytes(StandardCharsets.US_ASCII);
            byte[] digest = MD.digest(indexedInput);
            if (digest[0] == 0
                    && digest[1] == 0
                    && (digest[2] & 0xff) < 16) {
                password.append(Integer.toHexString(digest[2]));
                System.out.println(password);
            }
        }
    }

    private static void method2() {
        StringBuilder password = new StringBuilder("________");
        for (int i = 0, len = 0; len < 8; ++i) {
            byte[] indexedInput = (INPUT + i).getBytes(StandardCharsets.US_ASCII);
            byte[] digest = MD.digest(indexedInput);
            if (digest[0] == 0
                    && digest[1] == 0
                    && (digest[2] & 0xff) < 8) {
                int position = digest[2] & 0xff;
                if (password.charAt(position) == '_') {
                    int code = (digest[3] & 0xff) >> 4;
                    password.setCharAt(position, toHexChar(code));
                    ++len;
                    System.out.println(password);
                }
            }
        }
    }

    private static char toHexChar(int code) {
        return (char) (code < 10 ? '0' + code : 'a' + (code - 10));
    }
}
