package org.java.practice.java.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 晋阳 on 2017/11/11.
 */
public class ReflectionTest {
    public static void setObjectColor(Object obj) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        Class cls = obj.getClass();
        //获得类的私有方法
        Method method = cls.getDeclaredMethod("privateMethod", null);
        method.setAccessible(true); //没有设置就会报错
        //调用该方法
        method.invoke(obj, null);
    }

    public static void main(String args[]) throws SecurityException, IllegalArgumentException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        setObjectColor(new MyTest());
    }
}
