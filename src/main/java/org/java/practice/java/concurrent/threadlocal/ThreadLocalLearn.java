package org.java.practice.java.concurrent.threadlocal;

/**
 * Created by 晋阳 on 2017/12/17.
 */
public class ThreadLocalLearn {

    // 通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal seqNum = new ThreadLocal() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    // 获取下一个序列值
    public int getNextNum() {
        seqNum.set(1 + (int)seqNum.get());
        return (int) seqNum.get();
    }

}
