package org.java.practice.design.pattern.structural.adapter.objectadapter;

import org.java.practice.design.pattern.structural.adapter.classadapter.Source;
import org.java.practice.design.pattern.structural.adapter.classadapter.Targetable;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class Test {

    public static void main(String[] args) {
        Targetable target = new Wrapper(new Source());
        target.method1();
        target.method2();
    }
}
