package com.yang.joker.utils;

import java.io.ByteArrayOutputStream;

public class EncryptUtil {
    private static char[] base64EncodeChars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    EncryptUtil() {
    }

    public static String encode(byte[] unencrypted_pass) {
        StringBuffer sb = new StringBuffer();
        int pass_length = unencrypted_pass.length;
        int flag = 0;
        sb.append("{encrypted}");

        while(flag < pass_length) {
            int var4 = unencrypted_pass[flag++] & 255;
            if (flag == pass_length) {
                sb.append(base64EncodeChars[var4 >>> 2]);
                sb.append(base64EncodeChars[(var4 & 3) << 4]);
                sb.append("==");
                break;
            }

            int var5 = unencrypted_pass[flag++] & 255;
            if (flag == pass_length) {
                sb.append(base64EncodeChars[var4 >>> 2]);
                sb.append(base64EncodeChars[(var4 & 3) << 4 | (var5 & 240) >>> 4]);
                sb.append(base64EncodeChars[(var5 & 15) << 2]);
                sb.append("=");
                break;
            }

            int var6 = unencrypted_pass[flag++] & 255;
            sb.append(base64EncodeChars[var4 >>> 2]);
            sb.append(base64EncodeChars[(var4 & 3) << 4 | (var5 & 240) >>> 4]);
            sb.append(base64EncodeChars[(var5 & 15) << 2 | (var6 & 192) >>> 6]);
            sb.append(base64EncodeChars[var6 & 63]);
        }

        return sb.toString();
    }

    public static byte[] decode(String pass) {
        String encrypted_pass=pass.replace("{encrypted}", "");
        byte[] passBytes = encrypted_pass.getBytes();
        int pass_length = passBytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(pass_length);
        int flag = 0;

        while(flag < pass_length) {
            byte my_byte;
            do {
                my_byte = base64DecodeChars[passBytes[flag++]];
            } while(flag < pass_length && my_byte == -1);

            if (my_byte == -1) {
                break;
            }

            byte my_byte_2;
            do {
                my_byte_2 = base64DecodeChars[passBytes[flag++]];
            } while(flag < pass_length && my_byte_2 == -1);

            if (my_byte_2 == -1) {
                break;
            }

            byteArrayOutputStream.write(my_byte << 2 | (my_byte_2 & 48) >>> 4);

            byte my_byte_3;
            do {
                my_byte_3 = passBytes[flag++];
                if (my_byte_3 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }

                my_byte_3 = base64DecodeChars[my_byte_3];
            } while(flag < pass_length && my_byte_3 == -1);

            if (my_byte_3 == -1) {
                break;
            }

            byteArrayOutputStream.write((my_byte_2 & 15) << 4 | (my_byte_3 & 60) >>> 2);

            byte my_byte_4;
            do {
                my_byte_4 = passBytes[flag++];
                if (my_byte_4 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }

                my_byte_4 = base64DecodeChars[my_byte_4];
            } while(flag < pass_length && my_byte_4 == -1);

            if (my_byte_4 == -1) {
                break;
            }

            byteArrayOutputStream.write((my_byte_3 & 3) << 6 | my_byte_4);
        }

        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] var0)  {
        String str = "yang";
        byte[] my_pass = str.getBytes();
        String str1 = encode(my_pass);

        byte[] my_byte = decode(str1);
        String str3 = new String(my_byte);
        System.out.println(str1 + "   " + str3);
    }
}
