package org.java.practice.oom;

/**
 * 虚拟机栈StackOverFlow
 * Created by yang.jin on 10/09/2017.
 */
public class JVMStackSOF {

    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[]args)throws Throwable{
        JVMStackSOF oom=new JVMStackSOF();
        try{
            oom.stackLeak();
        }catch(Throwable e){
            System.out.println("stack length："+oom.stackLength);
            throw e;
        }
    }
}
