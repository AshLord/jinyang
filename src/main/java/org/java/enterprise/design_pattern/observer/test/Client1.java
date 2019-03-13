package org.java.enterprise.design_pattern.observer.test;
public class Client1 {

    public static void main(String[] args) {
        //创建主题对象
        ConcreteSubject1 subject1 = new ConcreteSubject1();
        //创建观察者对象
        Observer1 observer = new ConcreteObserver1();
        //将观察者对象登记到主题对象上
        subject1.attach(observer);
        //改变主题对象的状态
        subject1.change("new state");
    }

}