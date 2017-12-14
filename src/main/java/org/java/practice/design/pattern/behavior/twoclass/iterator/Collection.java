package org.java.practice.design.pattern.behavior.twoclass.iterator;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public interface Collection {

    public Iterator iterator();

    /*取得集合元素*/
    public Object get(int i);

    /*取得集合大小*/
    public int size();
}
