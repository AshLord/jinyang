package org.java.practice.java;

/**
 * @author yang.jin
 * date: 31/01/2018
 * desc:
 */
public class GrandSon extends Son {

    @Override
    void fatherFunc() {
        System.out.println("GrandSon Override fatherFunc");
    }

    public static void main(String[] args) {
        GrandSon grandSon = new GrandSon();
        grandSon.fatherFunc();

    }
}
