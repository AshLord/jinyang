package org.java.practice.web;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by 晋阳 on 2017/11/4.
 */
public class EncodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException, CharacterCodingException {

        String name = "我爱你";

        byte[] c1 = name.getBytes("ISO-8859-1");
        byte[] c2 = name.getBytes("GB2312");
        byte[] c3 = name.getBytes("GBK");
        byte[] c4 = name.getBytes("UTF-16");
        byte[] c5 = name.getBytes("UTF-8");

        System.out.println(c1.length);System.out.print(c1.toString());
        System.out.println(c2.length);System.out.print(c1.toString());
        System.out.println(c3.length);System.out.print(c1.toString());
        System.out.println(c4.length);System.out.print(c1.toString());
        System.out.println(c5.length);System.out.print(c1.toString());

        ByteBuffer byteBuffer = ByteBuffer.wrap(c5);
        CharBuffer charBuffer = CharBuffer.wrap(name);

        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer charBuffer1 = decoder.decode(byteBuffer);
        CharsetEncoder encoder = charset.newEncoder();
        ByteBuffer byteBuffer1 = encoder.encode(charBuffer);
    }

    public static byte[] getBooleanArray(byte b) {
        byte[] array = new byte[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte)(b & 1);
            b = (byte) (b >> 1);
        }
        return array;
    }

    public static String byteToBit(byte b) {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }
}
