package org.java.practice.java.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by 晋阳 on 2017/11/11.
 */
public class ReflectionTest {

    public static void main(String args[]) throws Exception{
        setObjectColor(new MyTest());
        System.out.println("-------------------------------------------------");
        threefunctionToGetClass();
    }

    public static void setObjectColor(Object obj) throws SecurityException,NoSuchMethodException, IllegalArgumentException, IllegalAccessException,InvocationTargetException {
        Class cls = obj.getClass();
        //获得类的私有方法
        Method method = cls.getDeclaredMethod("privateMethod", null);
        //没有设置就会报错
        method.setAccessible(true);
        //调用该方法
        method.invoke(obj, null);
    }

    public static void threefunctionToGetClass() throws Exception {
        Class class1 = Class.forName("org.java.practice.java.lang.reflect.MyTest");
        Class class2 = MyTest.class;
        Class class3 = new MyTest().getClass();

        Class class4 = ClassLoader.getPlatformClassLoader().loadClass("org.java.practice.java.lang.reflect.MyTest");

        MyTest object = (MyTest) class1.newInstance();
        Field[] fields = class1.getDeclaredFields();
        //定义可变长的字符串，用来存储属性
        StringBuffer sb = new StringBuffer();
        //通过追加的方法，将每个属性拼接到此字符串中
        //最外边的public定义
        sb.append(Modifier.toString(class1.getModifiers()) + " class " + class1.getSimpleName() +"{\n");
        //里边的每一个属性
        for(Field field:fields){
            sb.append("\t");//空格
            sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等
            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字
            sb.append(field.getName()+";\n");//属性的名字+回车
        }

        sb.append("}");
        System.out.println(sb);
    }
}
