package org.java.practice.design.pattern.structural.facade;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class User {

    /**
     * 外观模式是为了解决类与类之间的依赖关系的，像spring一样，可以将类和类之间的关系
     * 配置到配置文件中，而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间
     * 的耦合度，该模式中没有涉及到接口
     * @param args
     */
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
