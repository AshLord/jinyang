package org.java.practice.design.pattern.createmodel.singleton;

/**
 * Desc: 单例模式-懒加载
 * Date: 22/11/2017
 *
 * @author yang.jin
 */
public class SingletonLazy {

    private static SingletonLazy instance = null;

    private SingletonLazy(){}

    public static  SingletonLazy getInstance(){
        if (null == instance){
            createInstance();
        }
        return instance;
    }

    private synchronized static SingletonLazy createInstance(){
        if (null == instance){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
