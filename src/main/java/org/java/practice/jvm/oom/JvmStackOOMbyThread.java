package org.java.practice.jvm.oom;

/**
 * 通过创建线程让虚拟机栈OOM
 * Created by yang.jin on 10/09/2017.
 */
public class JvmStackOOMbyThread {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    /**
     * 谨慎运行，可能会造成操作系统OS假死
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        JvmStackOOMbyThread oom = new JvmStackOOMbyThread();
        oom.stackLeakByThread();
    }

}
