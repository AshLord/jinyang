package org.java.practice.design.pattern.createmodel.abstractfactory;

import org.java.practice.design.pattern.createmodel.factorymethod.MailSender;
import org.java.practice.design.pattern.createmodel.factorymethod.Sender;

/**
 * @author yang.jin
 * date: 11/12/2017
 * desc:
 */
public class SendMailFactory implements Provider{

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
