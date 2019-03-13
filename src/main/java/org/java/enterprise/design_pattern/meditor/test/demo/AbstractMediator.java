package org.java.enterprise.design_pattern.meditor.test.demo;
abstract class AbstractMediator {  
    protected AbstractColleague A;  
    protected AbstractColleague B;  
      
    public AbstractMediator(AbstractColleague a, AbstractColleague b) {  
        A = a;  
        B = b;  
    }  
  
    public abstract void AaffectB();  
      
    public abstract void BaffectA();  
  
}  