package org.java.practice.java;

/**
 * Created by yang.jin on 26/09/2017.
 */
public class Son extends Father{

    @Override
    void fatherFunc() {
        super.fatherFunc();
        System.out.println("Son Override fatherFunc");
    }

    //只有class文件中才能出现
    /*String fatherFunc() {

    }*/

    public static void main(String[] args) {
        Son son = new Son();
        son.fatherFunc();
    }
}
