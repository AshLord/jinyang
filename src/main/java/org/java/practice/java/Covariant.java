package org.java.practice.java;

import java.util.ArrayList;
import java.util.List;

public class Covariant {

    /**
     * JAVA数组存储的协变性
     * @param args
     */
    public static void main(String[] args) {
        Number[] nums = new Integer[5];
        nums[0] = 2.1;    //因为数组协变，编译不报错，运行时报错 throw ArrayStoreException

        //Cannot compile:
        //List<Number> numList = new ArrayList<Integer>();      //因为泛型不协变，所以无法编译

        List<Number> numList = new ArrayList<Number>();
        numList.add(2.1);
        numList.add(3);
        numList.add(319371983312L);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        numList.addAll(integers);

        Covariant covariant = new Covariant();

        //带有限制的泛型——数组
        Son[] sons = new Son[3];
        sons[0] = new Son();
        sons[1] = new Son();
        sons[2] = new Son();
        covariant.ifReqVarsCanBeLower(sons);    //编译通过了，因为数组有协变性

        //带有限制的泛型——集合
        List<Son> sonList = new ArrayList<>();
        sonList.add(new Son());
        sonList.add(new Son());
        sonList.add(new Son());
        //covariant.ifReqVarsCanBeLower(sonList);   //编译不通过，因为泛型没有协变性

    }


    public void ifReqVarsCanBeLower(List<Father> fatherList) {
        for (Father father : fatherList) {
            father.fatherFunc();
        }
    }

    public void ifReqVarsCanBeLower(Father[] fatherList) {
        for (Father father : fatherList) {
            father.fatherFunc();
        }
    }
}
