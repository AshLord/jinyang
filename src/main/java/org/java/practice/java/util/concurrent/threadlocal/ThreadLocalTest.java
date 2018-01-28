package org.java.practice.java.util.concurrent.threadlocal;

/**
 * Created by 晋阳 on 2017/12/17.
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocalLearn sn = new ThreadLocalLearn();
        //3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }
}
