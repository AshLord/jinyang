package org.java.practice.design.pattern.behavior.byintermediate.visitor;

/**
 * Created by yang.jin on 07/11/2017.
 */
public class ConcreteElement2 implements Element{

    private String value = "ConcreteElement2";

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getElement() {
        return value;
    }
}
