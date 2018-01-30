package org.java.practice.java.lang.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class FourReferences {

    static Object object = new Object();
    static String string = "Illidan·Stormrage";

    public static void main(String[] args) {

        strongRef();
        softRef();
        weakRef();
        phantomRef();
    }

    /**
     * 强引用
     * 在此说明一下，StrongReference只是对强引用的一个称呼，但是强引用没有对应的实体类。使用强引用的对象就算是内存出现outofmemory（内存溢出）
     的异常也不会回收。也就是说该对象永远不会被垃圾回收器回收，不论内存是否充足。平常代码中用的最多的就是强引用。
     */
    public static void strongRef() {
        Object obj = object;
        object = null;
        System.gc();
        System.out.print("after system.gc-strongReference---obj = " + obj);
    }

    /**
     * 软引用
     * 软引用有对应的实体列为SoftReference,使用软引用引用的对象只有在程序发生oom异常前才会回收，也就是说如果内存充足永远不会被回收，只有在内存不足时才会回收，很好的避免oom，非常适合做缓存。
     */
    public static void softRef() {
        SoftReference<Object> obj2 = new SoftReference<>(object);

        object = null;
        System.gc();
        System.out.print("after system.gc---softReference = " + obj2);
    }

    public static void weakRef() {
        WeakReference<Object> weakReference = new WeakReference<>(object);
        WeakReference<Object>  weakReferenceStr = new WeakReference<>(string);

        /**
         * 第二种情况，不对所引用的对象置为null，直接进行gc:
         * 可以看到，此时所引用的对象不为null，所以在进行gc回收时不会回收弱引用对象。由此可以看出弱引用跟对象的生命周期有关，在对象不为null时，垃圾回收器不会回收弱引用
         */
        object = null;
        string = null;

        /**
         * 第一种情况，如果把弱引用所引用的对象置为null，但不进行gc，弱引用的get到的会是null吗？
         * 可以看到如果不进行gc，弱引用对象在内存充足的情况下是不会回收的，不论所引用的对象是否为null
         */
        System.gc();
        System.out.println("after system.gc---weakReference = " + weakReference.get());
        System.out.print("after system.gc---weakReferenceStr = " + weakReferenceStr.get());
    }

    /**
     * 概念介绍，虚引用对应的实体类为PhantonReference。虚引用不论所引用的对象是不是null，不论内存空间是否充足，都会被垃圾回收器回收
     */
    public static void phantomRef(){
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object,referenceQueue);
        PhantomReference<Object> phantomReferenceStr = new PhantomReference<>(string,referenceQueue);
//        object = null;
//        str = null;
        System.gc();
        System.out.println("after system.gc---phantomReference = " + phantomReference.get());
        System.out.print("after system.gc---phantomReferenceStr = " + phantomReferenceStr.get());
    }

}
