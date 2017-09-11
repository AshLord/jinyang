package org.java.practice.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLib使方法区出现内存溢出异常
 * Created by yang.jin on 10/09/2017.
 */
public class JvmMethodAreaOOM {

    public static void main(String[]args){

        while(true){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor(){
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)throws Throwable{
                    return proxy.invokeSuper(obj,args);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject{
    }
}
