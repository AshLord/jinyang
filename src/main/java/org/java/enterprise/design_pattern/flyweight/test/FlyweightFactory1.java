package org.java.enterprise.design_pattern.flyweight.test;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory1 {
    private Map<Character,Flyweight1> files = new HashMap<Character,Flyweight1>();
    
    public Flyweight1 factory(Character state){
        //先从缓存中查找对象
        Flyweight1 fly = files.get(state);
        if(fly == null){
            //如果对象不存在则创建一个新的Flyweight对象
            fly = new ConcreteFlyweight1(state);
            //把这个新的Flyweight对象添加到缓存中
            files.put(state, fly);
        }
        return fly;
    }
}