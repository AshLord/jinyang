package org.java.practice.design.pattern.behavior.classstatus.memento;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
