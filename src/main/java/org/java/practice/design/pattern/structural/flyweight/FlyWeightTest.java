package org.java.practice.design.pattern.structural.flyweight;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class FlyWeightTest {

    /**
     * 享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用。
     */
    public static void main(String[] args) {
        FlyweightPattern fp = null;
        fp = new FlyweightPattern();
        fp.showFlyWeight();
    }
}
