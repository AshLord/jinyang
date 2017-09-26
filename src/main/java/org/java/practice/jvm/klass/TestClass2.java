package org.java.practice.jvm.klass;

/**
 * Created by yang.jin on 26/09/2017.
 */
public class TestClass2 {

    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
