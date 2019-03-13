package org.java.enterprise.design_pattern.visitor.test;
public class SubEast2 extends East{
    @Override
    public void goEast(West west) {
        west.goWest2(this);
    }
    
    public String myName2(){
        return "SubEast2";
    }
}