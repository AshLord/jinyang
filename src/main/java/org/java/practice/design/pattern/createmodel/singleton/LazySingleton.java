package org.java.practice.design.pattern.createmodel.singleton;

import java.util.Random;

/**
 * Created by 晋阳 on 2017/12/27.
 *
 * DCL失效讲解
 *
 * 双重检查加锁（Double Check Lock）
 *
 * 这里得到单一的instance实例是没有问题的，问题的关键在于尽管得到了Singleton的正确引用，但是却有可能
 * 访问到其成员变量的不正确值。具体来说Singleton.getInstance().getSomeField()有可能返回someField
 * 的默认值0。如果程序行为正确的话，这应当是不可能发生的事，因为在构造函数里设置的someField的值不可能为0。
 * 为也说明这种情况理论上有可能发生，我们只需要说明语句(1)和语句(7)并不存在happen-before关系。
 */
public class LazySingleton {
    private int someField;

    private static LazySingleton instance;

    private LazySingleton() {
        this.someField = new Random().nextInt(200)+1;         // (1)
    }

    /**
     * 假设线程Ⅰ是初次调用getInstance()方法，紧接着线程Ⅱ也调用了getInstance()方法和getSomeField()方法，
     我们要说明的是线程Ⅰ的语句(1)并不happen-before线程Ⅱ的语句(7)。线程Ⅱ在执行getInstance()方法的语句(2)
     时，由于对instance的访问并没有处于同步块中，因此线程Ⅱ可能观察到也可能观察不到线程Ⅰ在语句(5)时对
     instance的写入，也就是说instance的值可能为空也可能为非空。我们先假设instance的值非空，也就观察到了
     线程Ⅰ对instance的写入，这时线程Ⅱ就会执行语句(6)直接返回这个instance的值，然后对这个instance调用
     getSomeField()方法，该方法也是在没有任何同步情况被调用，因此整个线程Ⅱ的操作都是在没有同步的情况下调用 ，
     这时我们便无法利用上述8条happen-before规则得到线程Ⅰ的操作和线程Ⅱ的操作之间的任何有效的happen-before
     关系（主要考虑规则的第2条，但由于线程Ⅱ没有在进入synchronized块，因此不存在lock与unlock锁的问题），
     这说明线程Ⅰ的语句(1)和线程Ⅱ的语句(7)之间并不存在happen-before关系，这就意味着线程Ⅱ在执行语句(7)完全
     有可能观测不到线程Ⅰ在语句(1)处对someFiled写入的值，这就是DCL的问题所在。很荒谬，是吧？DCL原本是为了
     逃避同步，它达到了这个目的，也正是因为如此，它最终受到惩罚，这样的程序存在严重的bug，虽然这种bug被发现的
     概率绝对比中彩票的概率还要低得多，而且是转瞬即逝，更可怕的是，即使发生了你也不会想到是DCL所引起的。
     */
    public static LazySingleton getInstance() {
        if (instance == null) {                               // (2)
            synchronized(LazySingleton.class) {               // (3)
                if (instance == null) {                       // (4)
                    instance = new LazySingleton();           // (5)
                }
            }
        }
        return instance;                                      // (6)
    }

    public int getSomeField() {
        return this.someField;                                // (7)
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int result = LazySingleton.getInstance().getSomeField();
                System.out.println(result);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int result = LazySingleton.getInstance().getSomeField();
                System.out.println(result);
            }
        });

        thread1.start();
        thread2.start();
    }
    /**
     * 解决方案：
     1、最简单而且安全的解决方法是使用static内部类的思想，它利用的思想是：一个类直到被使用时
     才被初始化，而类初始化的过程是非并行的，这些都有JLS保证。

     2、另外，可以将instance声明为volatile，即
     private volatile static LazySingleton instance;
     */
}
