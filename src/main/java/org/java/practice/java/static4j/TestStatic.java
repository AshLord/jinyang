package org.java.practice.java.static4j;

public class TestStatic {

    public static void main(String[] args) {
        PlainClass plainClass = new PlainClass();

        PlainClass.InnerStaticClass innerStaticClass = new PlainClass.InnerStaticClass();

        innerStaticClass.nonStaticMethod();

        //内部静态类的方法是不能直接调用的
        //org.java.practice.java.static4j.PlainClass.InnerStaticClass.nonStaticMethod();
    }
}
