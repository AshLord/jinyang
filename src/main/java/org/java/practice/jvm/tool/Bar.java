package org.java.practice.jvm.tool;

/**
 * Created by 晋阳 on 2017/9/17.
 *
 * 演示一下Hsdis插件的使用
 *
 * java
 * -XX：+PrintAssembly 调用它来把动态生成的本地代码还原为汇编代码输出，同时还生成了大量非常有价值的注释
 * -Xcomp 让虚拟机以编译模式执行代码，这样代码可以“偷懒”，不需要执行足够次数来预热就能触发JIT编译
 * -XX：CompileCommand=dontinline，*Bar.sum
 * -XX：CompileCommand=compileonly，*Bar.sum test.Bar 让编译器不要内联sum（）并且只编译sum（）
 */
public class Bar {

    int a=1;
    static int b=2;
    public int sum(int c){
        return a+b+c;
    }

    public static void main(String[] args){
        new Bar().sum(3);
    }
}

