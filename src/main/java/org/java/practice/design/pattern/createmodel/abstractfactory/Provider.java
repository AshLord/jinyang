package org.java.practice.design.pattern.createmodel.abstractfactory;

import org.java.practice.design.pattern.createmodel.factorymethod.Sender;

/**
 * @author yang.jin
 * date: 11/12/2017
 * desc:
 */
public interface Provider {

    Sender produce();
}
