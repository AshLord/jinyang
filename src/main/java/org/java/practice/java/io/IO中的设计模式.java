package org.java.practice.java.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @author yang.jin
 * date: 25/01/2018
 * desc:
 */
public class IO中的设计模式 {

    public static void main(String[] args) throws FileNotFoundException {

        /**
         * 以上就是适配器模式的体现，FileInputStream是字节流，而并没有字符流读取字符的一些api，
         * 因此通过InputStreamReader将其转为Reader子类，因此有了可以操作文本的文件方法。换句话说，
         * 就是将FileInputStream读取一个字节流的方法扩展转换为InputStreamReader读取一个字符流的功能。
         */
        String file = "C:/sjdalf.txt";
        FileInputStream fileInput = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInput);

        /**
         * 构造了缓冲字符流，将FileInputStream字节流包装为BufferedReader过程就是装饰的过程，
         * 刚开始的字节流FileInputStream只有read一个字节的方法，包装为inputStreamReader后，
         * 就有了读取一个字符的功能，在包装为BufferedReader后，就拥有了read一行字符的功能。
         */
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
    }
}
