package org.java.practice.jdk8;

/**
 * @author yang.jin
 * date: 15/01/2018
 * desc:
 */
public class FunctionalInterface {

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);
        System.out.println("");
    }
}
