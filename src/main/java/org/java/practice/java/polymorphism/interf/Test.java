package org.java.practice.java.polymorphism.interf;

/**
 * @author yang.jin
 * date: 18/12/2017
 * desc:
 */
public class Test {

    public static void main(String[] args) {
        InterA a;
        a = new B();
        a.fun();
        a = new C();
        a.fun();
    }
}
