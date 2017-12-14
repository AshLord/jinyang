package org.java.practice.web.tomcat;

import org.apache.catalina.startup.Bootstrap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 晋阳 on 2017/11/8.
 */
public class LearnTomcat {

    /**
     * 反射调用
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void reflectInvoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //
        Bootstrap object = new Bootstrap();
        Class bootstrapClz = object.getClass();
        Method method = bootstrapClz.getDeclaredMethod("initClassLoaders", null);
        method.setAccessible(true);
        method.invoke(object,null);
    }

    ClassLoader commonLoader = null;

    /**
     * 学习tomcat 启动加载机制
     */
    public void learnTocatClassLoadMerchanism() {
        //commonLoader =
    }

    private ClassLoader createClassLoader(String name, ClassLoader parent) {
        return null;
    }
}
