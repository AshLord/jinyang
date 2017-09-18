package org.java.practice.jvm.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang.jin on 18/09/2017.
 */
public class OOMObject {

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }
}
