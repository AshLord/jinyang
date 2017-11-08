package org.java.practice.java;

/**
 * Created by 晋阳 on 2017/11/7.
 */
public class ThisRange {

    public static String a = "out";

    public static class InnerClass{

        public static String a = "in";

        public String getA() {
            return a;
        }

        public String getThisA() {
            return this.a;
        }

        public String getSuperA() {
            ThisRange thisRange = new ThisRange();
            return thisRange.a;
        }
    }
}
