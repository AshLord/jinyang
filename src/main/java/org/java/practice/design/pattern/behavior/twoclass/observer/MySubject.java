package org.java.practice.design.pattern.behavior.twoclass.observer;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }

}
