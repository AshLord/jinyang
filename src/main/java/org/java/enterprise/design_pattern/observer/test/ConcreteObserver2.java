package org.java.enterprise.design_pattern.observer.test;
public class ConcreteObserver2 implements Observer2 {
    //观察者的状态
    private String observerState;
    
    @Override
    public void update(Subject2 subject2) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = ((ConcreteSubject2)subject2).getState();
        System.out.println("观察者状态为："+observerState);
    }
}