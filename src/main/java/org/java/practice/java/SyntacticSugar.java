package org.java.practice.java;

/**
 * Created by yang.jin on 09/10/2017.
 */
public class SyntacticSugar {

    public static void main(String[] args) {
        /**
         * "=="：如果是基本数据类型，则直接对值进行比较，如果是引用数据类型，则是对他们的地址进行比较
         * （但是只能比较相同类型的对象，或者比较父类对象和子类对象。类型不同的两个对象不能使用==）
         *
         * equals方法继承自Object类，在具体实现时可以覆盖父类中的实现。看一下Object中equals的源码发现，
         * 它的实现也是对对象的地址进行比较，此时它和"=="的作用相同。而JDK类中有一些类覆盖了Object类的equals()方法，
         * 比较规则为：如果两个对象的类型一致，并且内容一致，则返回true,这些类有：
         * java.io.file,java.util.Date,java.lang.string，包装类（Integer,Double等）。
         *
         * 包装类“==”运算在不遇到算术运算的情况下不会自动拆箱
         * 包装类equals（）方法不处理数据转型的关系
         *
         * @See IntegerCache.class
         *
         * 通过观察IntegerCache的代码我们可以发现，Integer使用一个内部静态类中的一个静态数组保存了-128-127范围内的数据，
         * 静态数组在类加载以后是存在方法区的，并不是什么常量池。在自动装箱的时候，首先判断要装箱的数字的范围，
         * 如果在-128-127的范围则直接返回缓存中已有的对象，否则new一个新的对象。其他的包装类也有类似的实现方式，可以通过源码观察一下。
         */
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        System.out.println(c==d);//true Integer的常量池机制（-128~127），缓存地址相同
        System.out.println(c.equals(d));//true c和d指向的内存空间值相同，都为3
        System.out.println(c==(a+b));//true Integer的常量池机制（-128~127），缓存地址相同 自动拆箱后他们的值是相等的，返回True。
        System.out.println(c.equals(a+b));//true c和a+b指向的内存空间值相同，都为3 他们的值相同，而且类型相同，返回true。
        Integer e = 321;
        Integer f = 321;
        System.out.print("e==f : ");
        System.out.println(e==f);//false 两个类实例变量在堆中的内存空间地址不同？
        int h = 321;
        int i = 321;
        System.out.print("h==i : ");
        System.out.println(h==i);//true 编译时自动装箱，装箱后地址是相同的？
        Long g =3L;
        System.out.println(g==(a+b));//true 自动拆箱后他们的值相等，返回True。
        System.out.println(g.equals(a+b));//false 他们的值相同但是类型不同，返回false。
        String one = "jy";
        String two = "jy";
        System.out.println(one.equals(two));//true
        System.out.println(one ==  two);//true

    }
}
