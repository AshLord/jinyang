package org.java.practice.design.pattern.structural.bridge;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class BridgeTest {
    /**
     * 这样，就通过对Bridge类的调用，实现了对接口Sourceable的
     * 实现类SourceSub1和SourceSub2的调用。
     * @param args
     */
    public static void main(String[] args) {

        Bridge bridge = new MyBridge();

        /*调用第一个对象*/
        Sourceable source1 = new Sub1();
        bridge.setSource(source1);
        bridge.method();

        /*调用第二个对象*/
        Sourceable source2 = new Sub2();
        bridge.setSource(source2);
        bridge.method();
    }
    /**
     * JDBC同理：
     *
     * Client -----> DriverManager ---> Driver
     *                                    |
     *                       ---------------------------
     *                       |            |            |
     *                 MysqlDriver    OracleDriver  DB2Driver
     */
}
