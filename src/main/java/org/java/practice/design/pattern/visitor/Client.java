package org.java.practice.design.pattern.visitor;

/**
 * Created by yang.jin on 07/11/2017.
 */
public class Client {

    public static void main(String[] args) {
        Visitor visitor1 = new ConcreteVisitor1();
        Visitor visitor2 = new ConcreteVisitor2();
        Element element1 = new ConcreteElement1();
        Element element2 = new ConcreteElement2();
        element1.accept(visitor1);
        element1.accept(visitor2);
        element2.accept(visitor1);
        element2.accept(visitor2);
    }
}
