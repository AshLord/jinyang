package org.java.practice.design.pattern.behavior.twoclass.command;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
