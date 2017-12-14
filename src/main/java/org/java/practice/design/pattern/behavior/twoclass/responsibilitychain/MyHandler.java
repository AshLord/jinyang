package org.java.practice.design.pattern.behavior.twoclass.responsibilitychain;

/**
 * Created by 晋阳 on 2017/12/14.
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name+" deal!");
        if(getHandler()!=null){
            getHandler().operator();
        }
    }
}
