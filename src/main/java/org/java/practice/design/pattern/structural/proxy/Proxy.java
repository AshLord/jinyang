package org.java.practice.design.pattern.structural.proxy;

import org.java.practice.design.pattern.structural.decorator.Source;
import org.java.practice.design.pattern.structural.decorator.Sourceable;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class Proxy implements Sourceable{

    private Source source;
    public Proxy(){
        super();
        this.source = new Source();
    }
    @Override
    public void method() {
        before();
        source.method();
        after();
    }
    private void after() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }
}
