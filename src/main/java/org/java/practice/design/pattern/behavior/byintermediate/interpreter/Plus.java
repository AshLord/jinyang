package org.java.practice.design.pattern.behavior.byintermediate.interpreter;

/**
 * Created by 晋阳 on 2017/12/15.
 */
public class Plus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1()+context.getNum2();
    }
}
