package org.java.practice.jvm.classloader;

/**
 * Created by yang.jin on 07/11/2017.
 */
public class ClassNotFoundException {

    public static void main(String[] args) {
        try {
            Class.forName("notExistClass");
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            classLoader.loadClass("notExistClass");
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
