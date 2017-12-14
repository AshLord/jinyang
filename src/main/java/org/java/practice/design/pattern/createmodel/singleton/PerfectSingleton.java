package org.java.practice.design.pattern.createmodel.singleton;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class PerfectSingleton {

    /* 私有构造方法，防止被实例化 */
    private PerfectSingleton() {
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static PerfectSingleton instance = new PerfectSingleton();
    }

    /* 获取实例 */
    public static PerfectSingleton getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}
