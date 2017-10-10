package org.java.practice.java;

/**
 * Created by yang.jin on 28/09/2017.
 */
public class LocalVariable {

    public int a = 2;

    public int b = 3;

    public void func(int a) {
        System.out.println(this.a);
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        LocalVariable localVariable = new LocalVariable();
        localVariable.func(4);
    }
}
