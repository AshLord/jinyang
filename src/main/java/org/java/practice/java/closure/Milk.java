package org.java.practice.java.closure;

/**
 * Created by yang.jin on 11/09/2017.
 */
public class Milk {

    public final static String name = "纯牛奶";//名称

    private static int num = 16;//数量

    public Milk() {
        System.out.println(name + "：16/每箱");
    }

    /**
     * 闭包
     * 闭包能够将一个方法作为一个变量去存储，这个方法有能力去访问所在类的自由变量。
     * @return 返回一个喝牛奶的动作
     */
    public Active HaveMeals() {
        return new Active() {
            public void drink() {
                if (num == 0) {
                    System.out.println("木有了，都被你丫喝完了.");
                    return;
                }
                num--;
                System.out.println("喝掉一瓶牛奶");
            }
        };
    }

    /**
     * 获取剩余数量
     */
    public void currentNum() {
        System.out.println(name + "剩余：" + num);
    }
}
