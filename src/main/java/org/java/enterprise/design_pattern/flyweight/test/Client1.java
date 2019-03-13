package org.java.enterprise.design_pattern.flyweight.test;
public class Client1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FlyweightFactory1 factory = new FlyweightFactory1();
        Flyweight1 fly = factory.factory(new Character('a'));
        fly.operation("First Call");
        
        fly = factory.factory(new Character('b'));
        fly.operation("Second Call");
        
        fly = factory.factory(new Character('a'));
        fly.operation("Third Call");
    }

}