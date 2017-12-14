package org.java.practice.design.pattern.visitor;

/**
 * Created by yang.jin on 07/11/2017.
 */
public class ConcreteVisitor1 implements Visitor{

    @Override
    public void visit(Element ele) {
        System.out.println("ConcreteVisitor1 visit the element"+ele.getElement());
    }
}
