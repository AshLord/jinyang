package org.java.practice.design.pattern.structural.adapter.classadapter;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class AdapterTest {


    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}
