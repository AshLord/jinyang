package org.java.enterprise.design_pattern.flyweight.test;

import java.util.ArrayList;
import java.util.List;

public class Client2 {

    public static void main(String[] args) {
        List<Character> compositeState = new ArrayList<Character>();
        compositeState.add('a');
        compositeState.add('b');
        compositeState.add('c');
        compositeState.add('a');
        compositeState.add('b');
        
        FlyweightFactory2 flyFactory = new FlyweightFactory2();
        Flyweight2 compositeFly1 = flyFactory.factory(compositeState);
        Flyweight2 compositeFly2 = flyFactory.factory(compositeState);
        compositeFly1.operation("Composite Call");
        
        System.out.println("---------------------------------");        
        System.out.println("复合享元模式是否可以共享对象：" + (compositeFly1 == compositeFly2));
        
        Character state = 'a';
        Flyweight2 fly1 = flyFactory.factory(state);
        Flyweight2 fly2 = flyFactory.factory(state);
        System.out.println("单纯享元模式是否可以共享对象：" + (fly1 == fly2));
    }
}