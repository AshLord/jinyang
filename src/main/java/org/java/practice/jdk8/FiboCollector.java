package org.java.practice.jdk8;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * 自定义聚合器
 * 需要构造四要素：
 可变的结果容器提供器 Supplier<List<Integer>> = () -> [0, 1] ； 注意这里不能使用 Arrays.asList , 因为该方法生成的列表是不可变的。
 累积器 BiConsumer<List<Integer>, Integer> accumulator()： 这里流的元素未用，仅仅用来使计算进行和终止。新的元素从结果容器中取最后两个相加后产生新的结果放到结果容器中。
 组合器 BinaryOperator<List<Integer>> combiner() ： 照葫芦画瓢，目前没看出这步是做什么用；直接 return null; 也是OK的。
 最终转换器 Function<List<Integer>, List<Integer>> finisher() ：在最终转换器中，移除初始设置的两个值 0, 1 。
 */
public class FiboCollector implements Collector<Integer, List<Integer>, List<Integer>> {

    public Supplier<List<Integer>> supplier() {
        return () -> {
            List<Integer> result = new ArrayList<>();
            result.add(0); result.add(1);
            return result;
        };
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return (res, num) -> {
            Integer next = res.get(res.size()-1) + res.get(res.size()-2);
            res.add(next);
        };
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return null;
        //return (left, right) -> { left.addAll(right); return left; };
    }

    @Override
    public Function<List<Integer>, List<Integer>> finisher() {
        return res -> { res.remove(0); res.remove(1); return res; };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }

}
