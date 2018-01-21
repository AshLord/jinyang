package org.java.practice.jdk9;

/**
 * @author yang.jin
 * date: 17/01/2018
 * desc:
 */
public interface PrivateIntefaceMethod {

    void normalInterfaceMethod();

    default void interfaceMethodWithDefault() {
        init();
    }

    default void anotherDefaultMethod() { init(); }

    // This method is not part of the public API exposed by MyInterface
    private void init() { System.out.println("Initializing"); }
}
