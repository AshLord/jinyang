package org.java.practice.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用unsafe分配本机内存
 * 本机直接内存溢出
 * Created by yang.jin on 10/09/2017.
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024*1024;

    public static void main(String[]args)throws Exception{
        Field unsafeField=Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe=(Unsafe)unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
