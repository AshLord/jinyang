package org.java.practice.java.lang;

public class Chars {

    public static void main(String[] args) {
        Character character = 'a';
        System.out.println(Character.getName(25611));
        System.out.println(Character.getType('3')+" "+Character.getName(9));
        System.out.println(Character.getType('b')+" "+Character.getName(2));
        System.out.println(Character.getType('中')+" "+Character.getType(5) +Character.getName(15));
        System.out.println(Character.charCount(123));
        System.out.println(Character.digit('a',0));
    }
}
