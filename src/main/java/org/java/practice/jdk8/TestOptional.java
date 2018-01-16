package org.java.practice.jdk8;

import java.util.Optional;

/**
 * @author yang.jin
 * date: 16/01/2018
 * desc:
 */
public class TestOptional {


    /**
     * Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型
     * Optional 被定义为一个简单的容器，其值可能是null或者不是null。
     * 在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，而在Java 8中，
     * 不推荐你返回null而是返回Optional
     */
    public void testOptional() {
        Optional<String> optional = Optional.of("bam");
        optional.isPresent();
        optional.get();
        optional.orElse("fallback");
        optional.ifPresent(s -> System.out.println(s.charAt(0)));
    }
}
