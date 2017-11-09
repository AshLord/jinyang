package org.java.practice.jvm.classloader;

/**
 * Created by yang.jin on 07/11/2017.
 */
public class UnsatisfiedLinkError {

    public native void nativeMethod();

    static {
        System.loadLibrary("NoLib");
    }

    public static void main(String[] args) {
        new UnsatisfiedLinkError().nativeMethod();
    }
}
