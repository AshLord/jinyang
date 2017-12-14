package org.java.practice.design.pattern.structural.flyweight;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class ConcreteFlyweight extends Flyweight{

    private String string;

    public ConcreteFlyweight(String str) {
        string = str;
    }

    @Override
    public void operation() {
        System.out.println("ConcreteFlyweight:"+string);
    }
}
