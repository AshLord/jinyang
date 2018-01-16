package org.java.practice.jdk8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author yang.jin
 * date: 16/01/2018
 * desc:java.util.Stream 表示能应用在一组元素上一次执行的操作序列。
 * Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，而中间操作返回Stream本身，
 * 这样你就可以将多个操作依次串起来。
 * Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set， Map不支持。
 * Stream的操作可以串行执行或者并行执行。
 */
public class TestStream {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("伊利丹·怒风");
        strList.add("玛法里奥·怒风");
        strList.add("萨格拉斯");
        strList.add("卡德加");
        strList.add("先知维纶");

        TestStream testStream = new TestStream();
        //filter
        testStream.filter(strList);
        //sort
        testStream.sort(strList);
        //map
        testStream.map(strList);
        //match
        testStream.match(strList);
        //count
        testStream.count(strList);
        //reduce
        testStream.reduce(strList);
    }

    /**
     * 过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，所以我们可以在
     * 过滤后的结果来应用其他Stream操作（比如forEach）。
     * forEach需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。
     * @param list
     */
    public void filter(List<String> list) {
        list.stream().filter(s -> s.contains("怒风"))
                .forEach(System.out::println);
    }

    public void sort(List<String> list) {
        System.out.println();
        list.stream().sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    public void map(List<String> list) {
        System.out.println();
        list.stream().map(s -> "魔兽主宰：" + s)
                .forEach(System.out::println);
    }

    public void match(List<String> list) {
        System.out.println();
        boolean allBelongToStormrage = list.stream().allMatch(s -> s.contains("怒风"));
        boolean anyBelongToStormrage = list.stream().anyMatch(s -> s.contains("怒风"));
        boolean nooneBelongToStormrage = list.stream().noneMatch(s -> s.contains("怒风"));

        System.out.println("allBelongToStormrage:"+allBelongToStormrage);
        System.out.println("anyBelongToStormrage:"+anyBelongToStormrage);
        System.out.println("noneBelongToStormrage:"+nooneBelongToStormrage);
    }

    public void count(List<String> list) {
        System.out.println();
        long count = list.stream().count();
        System.out.println("count:"+count);
    }

    /**
     * 这是一个最终操作，允许通过指定的函数来讲stream中的多个元素规约为一个元素，规越后的结果是通过Optional接口表示
     * @param list
     */
    public void reduce(List<String> list) {
        System.out.println();
        Optional<String> reduce = list.stream().reduce(((s, s2) -> s + " 干掉 " + s2));
        reduce.ifPresent(System.out::println);
    }


}
