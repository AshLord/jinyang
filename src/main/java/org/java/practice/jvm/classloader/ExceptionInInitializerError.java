package org.java.practice.jvm.classloader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yang.jin on 07/11/2017.
 */
public class ExceptionInInitializerError {

    public static Map m = new HashMap(){
        {
            m.put("a", "2");
        }
    };

    public static void main(String[] args) {
        Integer isInt = (Integer) m.get("a");
        System.out.println(isInt);
    }
}
