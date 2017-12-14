package org.java.practice.design.pattern.createmodel.factorymethod;

/**
 * @author yang.jin
 * date: 11/12/2017
 * desc:
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
    }
}
