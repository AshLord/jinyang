package org.java.enterprise.design_pattern.meditor.test.demo;
class ColleagueB extends AbstractColleague{  
  
    @Override  
    public void setNumber(int number, AbstractMediator am) {  
        this.number = number;  
        am.BaffectA();  
    }  
}  