package org.java.practice.design.pattern.structural.adapter.classadapter;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
 */
public class AdapterTest {


    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}
