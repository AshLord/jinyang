package org.java.practice.design.pattern.behavior.byintermediate.mediator;

/**
 * Created by 晋阳 on 2017/12/15.
 */
public class MyMediator implements Mediator {

    public MyMediator() {
    }

    private User user1;
    private User user2;

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    @Override
    public void createMediator() {
        user1 = new User1(this);
        user2 = new User2(this);
    }

    @Override
    public void workAll() {
        user1.work();
        user2.work();
    }
}
