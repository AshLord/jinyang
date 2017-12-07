package org.java.practice.java.dynamicproxy.proxy2;

/**
 * @author yang.jin
 * date: 06/12/2017
 * desc:
 */
public class RealSubject implements Subject{

    @Override
    public void doSomething() {
        System.out.println( "call doSomething()" );
    }

    @Override
    public void doNextThing() {
        System.out.println("call doNextThing()");
    }
}
