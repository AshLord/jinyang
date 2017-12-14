package org.java.practice.design.pattern.behavior.twoclass.iterator;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class MyCollection implements Collection {

    public String string[] = {"A","B","C","D","E"};
    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return string[i];
    }

    @Override
    public int size() {
        return string.length;
    }
}
