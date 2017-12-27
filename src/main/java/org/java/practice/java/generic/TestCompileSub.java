package org.java.practice.java.generic;

/**
 * Created by 晋阳 on 2017/12/25.
 */
public class TestCompileSub extends TestCompileSuper{

    @Override
    public void test(Object/*注意这里不能是String！！否则编译报错*/ arg){}
}
