package org.java.practice.design.pattern.structural.decorator;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
