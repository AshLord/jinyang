package org.java.enterprise.design_pattern.abstarctfactory.test;


import org.java.enterprise.design_pattern.simplefactory.test.Cpu;
import org.java.enterprise.design_pattern.simplefactory.test.IntelCpu;
import org.java.enterprise.design_pattern.simplefactory.test.IntelMainboard;
import org.java.enterprise.design_pattern.simplefactory.test.Mainboard;

public class AmdFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        // TODO Auto-generated method stub
        return new IntelCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        // TODO Auto-generated method stub
        return new IntelMainboard(938);
    }

}