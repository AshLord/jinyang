package org.java.practice.java.polymorphism;

/**
 * @author yang.jin
 * date: 18/12/2017
 * desc:
 */
class Test
{
    public static void main(String[] args)
    {
        superA a;
        subB  b = new subB();
        subC  c = new subC();
        a=b;
        a.fun();
        a=c;
        a.fun();
    }
}
