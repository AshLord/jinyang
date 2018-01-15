package org.java.practice.jdk8;

import java.lang.FunctionalInterface;

/**
 * @author yang.jin
 * date: 15/01/2018
 * desc:
 */
@FunctionalInterface
public interface Converter<F,T> {

    T convert(F from);
}
