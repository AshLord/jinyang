package org.java.practice.design.pattern.behavior.byintermediate.mediator;

/**
 * Created by 晋阳 on 2017/12/15.
 */
public class User1 extends User {

    public User1(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exe!");
    }
}
