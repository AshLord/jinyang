package org.java.enterprise.design_pattern.visitor.test;
public class Client1 {

    public static void main(String[] args) {
        Horse h = new BlackHorse();
        h.eat();
    }

}