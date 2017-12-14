package org.java.practice.design.pattern.createmodel.factorymethod;

/**
 * @author yang.jin
 * date: 11/12/2017
 * desc:
 */
public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

}
