package org.java.practice.design.pattern.behavior.byintermediate.mediator;

/**
 * Created by 晋阳 on 2017/12/15.
 */
public abstract class User {

    private Mediator mediator;

    public Mediator getMediator(){
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}
