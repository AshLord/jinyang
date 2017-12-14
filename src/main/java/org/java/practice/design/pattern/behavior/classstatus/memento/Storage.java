package org.java.practice.design.pattern.behavior.classstatus.memento;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class Storage {

    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
