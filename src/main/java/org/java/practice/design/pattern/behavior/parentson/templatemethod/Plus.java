package org.java.practice.design.pattern.behavior.parentson.templatemethod;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class Plus extends AbstractCalculator {

    @Override
    public int calculate(int num1,int num2) {
        return num1 + num2;
    }
}
