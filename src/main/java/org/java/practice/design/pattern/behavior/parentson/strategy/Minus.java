package org.java.practice.design.pattern.behavior.parentson.strategy;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class Minus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"-");
        return arrayInt[0]-arrayInt[1];
    }

}