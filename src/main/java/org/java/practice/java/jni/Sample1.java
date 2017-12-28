package org.java.practice.java.jni;

/**
 * @author yang.jin
 * date: 25/12/2017
 * desc:
 */
public class Sample1 {

    /**
     * 4个native方法就是我们需要用C来实现的方法。
     * @param n
     * @return
     */
    public native int intMethod(int n);

    public native boolean booleanMethod(boolean bool);

    public native String stringMethod(String text);

    public native int intArrayMethod(int[] intArray);

    /**
     * 第一步：javac -encoding UTF-8 Sample1.java
     * 第二步：javah -encoding UTF-8 -classpath E:/practice/src/main/java/org/java/practice/java/jni Sample1
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 这句话加载了动态类库
         * 在windows下加载的就是Sample1.dll, 在linux下加载的就是Sample1.so。
         * 注意：不可以在代码中写上后缀dll或so. 还要保证Sample1.dll在path路径中. 这个Sample1.dll是我们后面需要编译出来的东西。
         */
        System.loadLibrary("Sample1");

        Sample1 sample = new Sample1();
        int square = sample.intMethod(5);
        boolean bool = sample.booleanMethod(true);
        String text = sample.stringMethod("Java");
        int sum = sample.intArrayMethod(new int[]{1, 2, 3, 4, 5, 8, 13});

        System.out.println("intMethod: " + square);
        System.out.println("booleanMethod: " + bool);
        System.out.println("stringMethod: " + text);
        System.out.println("intArrayMethod: " + sum);
    }
}
