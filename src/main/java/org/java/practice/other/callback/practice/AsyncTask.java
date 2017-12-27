package org.java.practice.other.callback.practice;

import org.java.practice.other.callback.CallBack;

/**
 * Created by 晋阳 on 2017/12/25.
 */
public class AsyncTask {

    public void asyncProcess(CallBack callBack,String result) throws InterruptedException {
        System.out.println("开始执行:"+result);
        Thread.sleep(3000);
        System.out.println("执行完毕："+result);
        callBack.solve("异步处理结果");
    }
}
