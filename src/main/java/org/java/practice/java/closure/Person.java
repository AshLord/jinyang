package org.java.practice.java.closure;

/**
 * Created by yang.jin on 11/09/2017.
 */
public class Person {

    public static void main(String[] args) {
        //买一箱牛奶
        Milk m = new Milk();

        Active haveMeals = m.HaveMeals();

        //没事喝一瓶
        haveMeals.drink();
        //有事喝一瓶
        haveMeals.drink();

        //看看还剩多少？
        m.currentNum();
    }

}
