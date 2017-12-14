package org.java.practice.design.pattern.behavior.twoclass.iterator;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public interface Iterator {

    //前移
    public Object previous();

    //后移
    public Object next();


    public boolean hasNext();

    //取得第一个元素
    public Object first();
}
