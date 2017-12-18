package org.java.practice.design.pattern.behavior.byintermediate.mediator;

/**
 * Created by 晋阳 on 2017/12/15.
 */
public class User2 extends User {

    public User2(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}
