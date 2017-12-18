package org.java.practice.design.pattern.behavior.classstatus.memento;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class MementoTest {
    /**
     * 主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，通俗的讲下：
     * 假设有原始类A，A中有各种属性，A可以决定需要备份的属性，备忘录类B是用来存储A的一些内部状态，类C呢，
     * 就是一个用来存储备忘录的，且只能存储，不能修改等操作。
     *
     * 其实我觉得这个模式叫“备份-恢复”模式最形象！
     */
    public static void main(String[] args) {

        // 创建原始类
        Original origi = new Original("egg");

        // 备忘录
        Memento memento = origi.createMemento();

        // 备忘录容器
        Storage storage = new Storage(memento);

        // 修改原始类的状态
        System.out.println("初始化状态为：" + origi.getValue());
        origi.setValue("niu");
        System.out.println("修改后的状态为：" + origi.getValue());

        // 回复原始类的状态
        origi.restoreMemento(storage.getMemento());
        System.out.println("恢复后的状态为：" + origi.getValue());
    }
}
