package org.java.practice.java.lang.reflect.dynamicproxy.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yang.jin
 * date: 06/12/2017
 * desc:
 */
public class ProxyHandler implements InvocationHandler {

    public static void main(String args[])
    {
        ProxyHandler proxy = new ProxyHandler();
        //绑定该类实现的所有接口
        Subject sub = (Subject) proxy.newProxyInstance(new RealSubject());
        sub.doSomething();
        sub.doNextThing();
    }

    private Object tar;

    //绑定委托对象，并返回代理类
    public Object newProxyInstance(Object tar)
    {
        this.tar = tar;
        //绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy , Method method , Object[] args)throws Throwable
    {
        Object result = null;
        //这里就可以进行所谓的AOP编程了
        //在调用具体函数方法前，执行功能处理
        System.out.println("before "+method.getName());
        result = method.invoke(tar,args);
        //在调用具体函数方法后，执行功能处理
        System.out.println("after "+method.getName());
        return result;
    }
}
