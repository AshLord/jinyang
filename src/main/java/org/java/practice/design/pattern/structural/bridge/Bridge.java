package org.java.practice.design.pattern.structural.bridge;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class Bridge {

    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
