package org.java.enterprise.design_pattern.observer.test;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject1 {
    /**
     * 用来保存注册的观察者对象
     */
    private    List<Observer1> list = new ArrayList<Observer1>();
    /**
     * 注册观察者对象
     * @param observer    观察者对象
     */
    public void attach(Observer1 observer){
        
        list.add(observer);
        System.out.println("Attached an observer");
    }
    /**
     * 删除观察者对象
     * @param observer    观察者对象
     */
    public void detach(Observer1 observer){
        
        list.remove(observer);
    }
    /**
     * 通知所有注册的观察者对象
     */
    public void nodifyObservers(String newState){
        
        for(Observer1 observer : list){
            observer.update(newState);
        }
    }
}