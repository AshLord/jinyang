package org.java.practice.design.pattern.structural.bridge;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class MyBridge extends Bridge{

    @Override
    public void method(){
        getSource().method();
    }
}
