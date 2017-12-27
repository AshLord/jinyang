package org.java.practice.java.generic;

import java.sql.BatchUpdateException;

/**
 * Created by 晋阳 on 2017/12/25.
 */
class Sub extends Super<BatchUpdateException>{

    @Override
    public void test() throws BatchUpdateException{
        //这里必须与参数类型保持一致，否则编译不通过。
    }
}
