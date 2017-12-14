package org.java.practice.design.pattern.behavior.twoclass.observer;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class ObserverTest {

    /**
     * 包括这个模式在内的接下来的四个模式，都是类和类之间的关系，不涉及到继承，学的时候应该 记得归纳，
     * 记得本文最开始的那个图。观察者模式很好理解，类似于邮件订阅和RSS订阅，当我们浏览一些博客或wiki
     * 时，经常会看到RSS图标，就这的意思是，当你订阅了该文章，如果后续有更新，会及时通知你。其实，简
     * 单来讲就一句话：当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变化！对象之间是一
     * 种一对多的关系
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 我解释下这些类的作用：MySubject类就是我们的主对象，Observer1和Observer2是依赖于MySubject的
         * 对象，当MySubject变化时，Observer1和Observer2必然变化。AbstractSubject类中定义着需要监控
         * 的对象列表，可以对其进行修改：增加或删除被监控对象，且当MySubject变化时，负责通知在列表内存在的对象
         */
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
