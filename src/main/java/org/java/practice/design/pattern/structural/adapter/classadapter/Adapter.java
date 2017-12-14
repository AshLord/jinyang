package org.java.practice.design.pattern.structural.adapter.classadapter;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
