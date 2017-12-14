package org.java.practice.design.pattern.behavior.twoclass.responsibilitychain;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public abstract class AbstractHandler {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
