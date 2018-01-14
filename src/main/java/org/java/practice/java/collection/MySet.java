package org.java.practice.java.collection;

import java.util.List;

/**
 * Created by 晋阳 on 2018/1/12.
 */
public class MySet<T> {

    private List<T> list;

    public void add(T ele) {
        if (list.contains(ele)) {
            return;
        }
        list.add(ele);
    }

    public void remove(T ele) {
        list.remove(ele);
    }


}
