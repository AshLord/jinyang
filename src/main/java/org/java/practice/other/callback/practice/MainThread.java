package org.java.practice.other.callback.practice;

import org.java.practice.other.callback.CallBack;

/**
 * Created by 晋阳 on 2017/12/25.
 */
public class MainThread implements CallBack {

    private AsyncTask asyncTask = null;

    public MainThread(AsyncTask asyncTask) {
        this.asyncTask = asyncTask;
    }

    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    asyncTask.asyncProcess(MainThread.this,"异步任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void solve(String result) {
        System.out.println("得到回调结果："+result);
    }
}
