package org.java.practice.design.pattern.createmodel.factorymethod;

/**
 * @author yang.jin
 * date: 11/12/2017
 * desc:
 */
public class SmsSender implements Sender{

    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
