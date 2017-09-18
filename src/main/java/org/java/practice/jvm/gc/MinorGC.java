package org.java.practice.jvm.gc;

/**
 * Created by yang.jin on 15/09/2017.
 */
public class MinorGC {

    private static final int _1MB=1024*1024;
    /**
     *VM参数：-verbose：gc-XX：+PrintGCDetails

     */
    public static void testAllocation(){

        /**
         * java堆一共20M -Xms20M-Xmx20M
         *
         * 新生代 10M 老年代 10M  -Xmn10M
         *
         * Eden 8M FromSurvivor 1M ToSurvivor 1M -XX：SurvivorRatio=8
         *
         */
        byte[]allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[2*_1MB];
        allocation2=new byte[2*_1MB];
        allocation3=new byte[2*_1MB];
        allocation4=new byte[4*_1MB];//出现一次Minor GC
    }
}
