package org.java.practice.java.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 晋阳 on 2017/12/17.
 * 下面是一个阻塞队列的实现：
 */
public class BlockQueue {

    private List list = new ArrayList();

    public synchronized Object pop() throws InterruptedException{
        while (list.size()==0){
            this.wait();
        }
        if (list.size()>0){
            return list.remove(0);
        } else{
            return null;
        }
    }

    public synchronized Object push(Object obj){
        list.add(obj);
        this.notify();
        return obj;
    }

    //synchronized配合wait()、notify()应该是Java开发者必须掌握的基本技能。


}
