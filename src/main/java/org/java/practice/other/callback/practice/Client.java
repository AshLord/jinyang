package org.java.practice.other.callback.practice;

/**
 * Created by 晋阳 on 2017/12/25.
 */
public class Client {

    public static void main(String[] args) {
        AsyncTask asyncTask = new AsyncTask();
        MainThread mainThread = new MainThread(asyncTask);
        mainThread.execute();
    }
}
