package org.java.practice.jdk8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.jin
 * date: 15/01/2018
 * desc: java8特性：方法引用
 */
public class MethodReferences {

    public boolean compareString() {
        List<String> list = new ArrayList<>();
        list.add("中国");
        list.add("美国");
        list.add("俄罗斯");
        list.add("朝鲜");

        //java8特性：方法引用
        list.sort(String :: compareToIgnoreCase);
        return true;
    }
}
