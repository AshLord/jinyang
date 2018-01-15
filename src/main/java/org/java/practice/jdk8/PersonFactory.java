package org.java.practice.jdk8;

import java.lang.FunctionalInterface;

/**
 * @author yang.jin
 * date: 15/01/2018
 * desc:
 */
@FunctionalInterface
public interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }
}
