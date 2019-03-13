package org.java.enterprise.design_pattern.adapert.test;
public class Adapter2  {
	private Adaptee2 adaptee2;

public Adapter2(Adaptee2 adaptee2){
    this.adaptee2 = adaptee2;
}
/**
 * 源类Adaptee有方法sampleOperation1
 * 因此适配器类直接委派即可
 */
public void sampleOperation1(){
    this.adaptee2.sampleOperation1();
}
/**
 * 源类Adaptee没有方法sampleOperation2
 * 因此由适配器类需要补充此方法
 */
public void sampleOperation2(){
    //写相关的代码
}

}