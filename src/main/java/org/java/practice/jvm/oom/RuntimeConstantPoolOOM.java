package org.java.practice.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区MethodArea运行时常量池OOM
 *
 * Created by yang.jin on 10/09/2017.
 */
public class RuntimeConstantPoolOOM {

    /**
     * JDK 1.6：
     * Exception in thread"main"java.lang.OutOfMemoryError：PermGen space
     *
     * JDK 1.7：
     * 不会throw异常
     */
    public static void main(String[] args) {

        /**
         * JDK 1.6中运行，会得到两个false
         * JDK 1.7中运行，会得到一个true和一个false
         */
        String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);
        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);

        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();

        //10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }

    }

}
