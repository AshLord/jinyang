package org.java.practice.java.lang.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class FindVirtual {

    public void run1() {
        System.out.println("run1");
    }

    public static void main(String[] args) {
        FindVirtual demo = new FindVirtual();
        try {
            MethodHandle mh = java.lang.invoke.MethodHandles.lookup().findVirtual(FindVirtual.class, "run1", MethodType.methodType(void.class));
            mh.invoke(demo);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
