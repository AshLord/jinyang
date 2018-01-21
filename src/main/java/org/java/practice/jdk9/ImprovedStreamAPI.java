package org.java.practice.jdk9;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yang.jin
 * date: 17/01/2018
 * desc:
 */
public class ImprovedStreamAPI {

    public static void main(String[] args) {

        IntStream.iterate(1, i -> i < 100, i -> i + 1).forEach(System.out::println);

        /**
         * Optional 和 Stream 之间的结合也得到了改进。现在可以通过 Optional 的新方法 `stram`
         * 将一个 Optional 对象转换为一个(可能是空的) Stream 对象：
         *
         * 在组合复杂的 Stream 管道时，将 Optional 转换为 Stream 非常有用。
         */
        Stream<Integer> s = Optional.of(1).stream();
    }
}
