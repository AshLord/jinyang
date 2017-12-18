package org.java.practice.java.concurrent.threadlocal;

/**
 * Created by 晋阳 on 2017/12/17.
 */
public class TestClient extends Thread {
    private ThreadLocalLearn sn;
    public TestClient(ThreadLocalLearn sn) {
        this.sn = sn;
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            // 每个线程打出3个序列值
            System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                    + sn.getNextNum() + "]");
        }
    }
}
