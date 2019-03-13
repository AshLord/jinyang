package org.java.enterprise.design_pattern.adapert.test;
public class Adapter1 extends Adaptee1 implements Target1 {
    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        //写相关的代码
    }

}