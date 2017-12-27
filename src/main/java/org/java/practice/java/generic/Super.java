package org.java.practice.java.generic;

import java.sql.SQLException;

/**
 * Created by 晋阳 on 2017/12/25.
 */
class Super<T extends SQLException>{

    public void test() throws T{}    //别怀疑，这段代码是可以编译通过的......

    //Super的参数类型被擦除之后，变成了:

    /*

    class Super<SQLException>{
        public void test() throws SQLException{}
    }

    */
}
