package org.java.practice.jvm.oom;

/**
 * 虚拟机栈StackOverFlow
 * Created by yang.jin on 10/09/2017.
 */
public class JvmStackSOF {

    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[]args)throws Throwable{
        JvmStackSOF oom=new JvmStackSOF();
        try{
            oom.stackLeak();
        }catch(Throwable e){
            System.out.println("stack length："+oom.stackLength);
            throw e;
        }
    }
}
