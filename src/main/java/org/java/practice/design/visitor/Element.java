package org.java.practice.design.visitor;

/**
 * Created by yang.jin on 07/11/2017.
 */
public interface Element {

    void accept(Visitor visitor);

    String getElement();
}
