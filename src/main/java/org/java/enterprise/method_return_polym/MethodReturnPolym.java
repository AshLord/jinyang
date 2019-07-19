package org.java.enterprise.method_return_polym;

/**
 * TODO
 *
 * @author jinyang
 * @date 2019/5/28 0028.
 */
public class MethodReturnPolym {

    public ReturnMultiply methodReturnPolym() {
        return new ReturnMultiply() {
            @Override
            public int getInt() {
                return 0;
            }

            @Override
            public String getString() {
                return null;
            }
        };
    }
}
