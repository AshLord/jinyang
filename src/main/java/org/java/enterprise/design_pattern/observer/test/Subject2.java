package org.java.enterprise.design_pattern.observer.test;

import java.util.ArrayList;
import java.util.List;

public class Subject2 {
    /**
     * 用来保存注册的观察者对象
     */
    private    List<Observer2> list = new ArrayList<Observer2>();
    /**
     * 注册观察者对象
     * @param observer    观察者对象
     */
    public void attach(Observer2 observer2){
        
        list.add(observer2);
        System.out.println("Attached an observer2");
    }
    /**
     * 删除观察者对象
     * @param observer    观察者对象
     */
    public void detach(Observer2 observer2){
        
        list.remove(observer2);
    }
    /**
     * 通知所有注册的观察者对象
     */
    public void nodifyObservers(){
        
        for(Observer2 observer2 : list){
            observer2.update(this);
        }
    }}
