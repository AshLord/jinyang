package org.java.enterprise.design_pattern.flyweight.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightFactory2 {
    private Map<Character,Flyweight2> files = new HashMap<Character,Flyweight2>();
    /**
     * 复合享元工厂方法
     */
    public Flyweight2 factory(List<Character> compositeState){
        ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
        
        for(Character state : compositeState){
            compositeFly.add(state,this.factory(state));
        }
        
        return compositeFly;
    }
    /**
     * 单纯享元工厂方法
     */
    public Flyweight2 factory(Character state){
        //先从缓存中查找对象
        Flyweight2 fly = files.get(state);
        if(fly == null){
            //如果对象不存在则创建一个新的Flyweight对象
            fly = new ConcreteFlyweight2(state);
            //把这个新的Flyweight对象添加到缓存中
            files.put(state, fly);
        }
        return fly;
    }}