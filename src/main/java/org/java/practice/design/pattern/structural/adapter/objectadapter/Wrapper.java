package org.java.practice.design.pattern.structural.adapter.objectadapter;

import org.java.practice.design.pattern.structural.adapter.classadapter.Source;
import org.java.practice.design.pattern.structural.adapter.classadapter.Targetable;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source){
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
