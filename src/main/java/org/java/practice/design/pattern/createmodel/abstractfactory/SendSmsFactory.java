package org.java.practice.design.pattern.createmodel.abstractfactory;

import org.java.practice.design.pattern.createmodel.factorymethod.Sender;
import org.java.practice.design.pattern.createmodel.factorymethod.SmsSender;

/**
 * @author yang.jin
 * date: 11/12/2017
 * desc:
 */
public class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
