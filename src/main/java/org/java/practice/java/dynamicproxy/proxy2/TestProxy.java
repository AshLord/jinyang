package org.java.practice.java.dynamicproxy.proxy2;

/**
 * @author yang.jin
 * date: 06/12/2017
 * desc:
 */
public class TestProxy {

    public static void main(String args[])
    {
        ProxyHandler proxy = new ProxyHandler();
        //绑定该类实现的所有接口
        Subject sub = (Subject) proxy.bind(new RealSubject());
        sub.doSomething();
        sub.doNextThing();
    }

}
