package org.java.practice.design.pattern.behavior.twoclass.observer;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
