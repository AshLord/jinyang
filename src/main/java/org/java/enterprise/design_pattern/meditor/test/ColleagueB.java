package org.java.enterprise.design_pattern.meditor.test;
class ColleagueB extends AbstractColleague{  
      
    public void setNumber(int number, AbstractColleague coll) {  
        this.number = number;  
        coll.setNumber(number/100);  
    }  
}  