package org.java.practice.design.pattern.structural.decorator;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class Decorator implements Sourceable {
    private Sourceable source;

    public Decorator(Sourceable source){
        super();
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
