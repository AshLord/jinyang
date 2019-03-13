package org.java.enterprise.design_pattern.observer.test;
public class Client2 {

    public static void main(String[] args) {
        //创建主题对象
        ConcreteSubject2 subject2 = new ConcreteSubject2();
        //创建观察者对象
        Observer2 observer = new ConcreteObserver2();
        //将观察者对象登记到主题对象上
        subject2.attach(observer);
        //改变主题对象的状态
        subject2.change("new state");
    }

}