package org.java.practice.java;

/**
 * Created by yang.jin on 10/10/2017.
 */
public class FieldAccessFlag {

    public String a;

    private String b;

    protected String c;

    static String d;

    final String e = "123";

    /**
     * volatile
     * 多线程可见性
     *
     */
    volatile String f;

    transient String g;

    enum h{};
}
