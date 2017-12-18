package org.java.practice.design.pattern.behavior.byintermediate.interpreter;

/**
 * Created by 晋阳 on 2017/12/15.
 */
public class InterpreterTest {
    /**
     * 一般主要应用在OOP开发中的编译器的开发中，所以适用面比较窄。
     * 解释器模式用来做各种各样的解释器，如正则表达式等的解释器等等！
     */
    public static void main(String[] args) {

        // 计算9+2-8的值
        int result = new Minus().interpret((new Context(new Plus()
                .interpret(new Context(9, 2)), 8)));
        System.out.println(result);

        // 步骤分解
        detail();
    }

    public static void detail() {
        Context context1 = new Context(9, 2);
        Expression expressionPlus = new Plus();
        int result1 = expressionPlus.interpret(context1);

        Context context2 = new Context(result1, 8);
        Expression expressionMinus = new Minus();
        int result2 = expressionMinus.interpret(context2);

        System.out.println(result2);

    }
}
