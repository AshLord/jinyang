package org.java.practice.java;

/**
 * Created by 晋阳 on 2017/9/24.
 */
public class SonOfAbstractClass extends AccessFlag{

    @Override
    void fun7() {

    }

    /**
     * 可以不用重写抽象方法fun7，却间接执行了fun7
     * 这算不算JAVA的Bug ？？？
     */
    void funOfSonClass() {
        execFun7();
    }
}
