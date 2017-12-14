package org.java.practice.design.pattern.structural.adapter.interfaceadapter;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class SourceSub2 extends Wrapper2 {

    @Override
    public void method2(){
        System.out.println("the sourceable interface's second Sub2!");
    }
}
