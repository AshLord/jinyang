package org.java.practice.java.lang.reflect;

/**
 * Created by 晋阳 on 2017/11/11.
 */
public class MyTest {

    private String val1;

    private String val2;

    private String val3;

    public void setMyTest(){
        System.out.println("setMyTest");
    }

    /**
    类的私有方法
     **/
    private void privateMethod(){
        System.out.println("调用了 private Method");
    }
}
