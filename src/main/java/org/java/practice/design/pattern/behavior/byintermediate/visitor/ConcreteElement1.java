package org.java.practice.design.pattern.behavior.byintermediate.visitor;

/**
 * Created by yang.jin on 07/11/2017.
 */
public class ConcreteElement1 implements Element{

    private String value = "ConcreteElement1";

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getElement() {
        return value;
    }
}
