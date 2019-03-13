package org.java.enterprise.design_pattern.state.lift.test;
public class Client2 {  
    public static void main(String[] args) {  
        Context context = new Context();  
        context.setLiftState(new ClosingState());  
        context.open();  
        context.close();  
        context.run();  
        context.stop();  
    }  
}  