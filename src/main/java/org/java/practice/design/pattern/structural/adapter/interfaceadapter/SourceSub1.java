package org.java.practice.design.pattern.structural.adapter.interfaceadapter;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class SourceSub1 extends Wrapper2{

    @Override
    public void method1(){
        System.out.println("the sourceable interface's first Sub1!");
    }
}
