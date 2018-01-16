package org.java.practice.jdk8;

import java.lang.annotation.Repeatable;

/**
 * @author yang.jin
 * date: 16/01/2018
 * desc:Java 8允许我们把同一个类型的注解使用多次，只需要给该注解标注一下@Repeatable即可。
 */
@Repeatable(Hints.class)
public @interface Hint {
    String value();
}
