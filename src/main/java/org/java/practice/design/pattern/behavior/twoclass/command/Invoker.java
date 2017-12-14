package org.java.practice.design.pattern.behavior.twoclass.command;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
