package org.java.enterprise.design_pattern.meditor.test.demo;
class ColleagueA extends AbstractColleague{  
  
    public void setNumber(int number, AbstractMediator am) {  
        this.number = number;  
        am.AaffectB();  
    }  
}  