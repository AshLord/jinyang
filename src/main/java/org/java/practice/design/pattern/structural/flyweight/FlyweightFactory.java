package org.java.practice.design.pattern.structural.flyweight;

import java.util.Hashtable;

/**
 * Created by 晋阳 on 2017/12/14.
 * 这个工厂方法类非常关键，这里详细解释一下：

 　　在1处定义了一个Hashtable用来存储各个对象；在2处选出要实例化的对象，在6处将该对象返回，如果
 在Hashtable中没有要选择的对 象，此时变量flyweight为null，产生一个新的flyweight存储在Hasht
 able中，并将该对象返回。
 */
public class FlyweightFactory {

    private Hashtable flyweights = new Hashtable();

    public FlyweightFactory() {

    }

    public Flyweight getFlyWeight(Object obj) {
        Flyweight flyweight = (Flyweight) flyweights.get(obj);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight((String) obj);
            flyweights.put(obj, flyweight);
        }
        return flyweight;
    }

    public int getFlyWeightSize() {
        return flyweights.size();
    }
}
