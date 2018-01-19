package org.java.practice.jdk8;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author yang.jin
 * date: 15/01/2018
 * desc:
 */
public class FunctionalInterface {

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);
        System.out.println("");
    }

    /**
     * Predicate 接口只有一个参数，返回boolean类型。该接口包含多种默认方法来将Predicate
     * 组合成其他复杂的逻辑（比如：与，或，非）：
     */
    public void testPredicate() {
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");
        // true
        predicate.negate().test("foo");
        // false
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

    /**
     * Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法
     * （compose, andThen）：
     */
    public void testFunction() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");
        // "123" i
    }

    /**
     * Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
     */
    public void testSupplier() {
        Supplier<Person> personSupplier = Person::new;
        Person newPerson = personSupplier.get();
        // new Person
    }

    /**
     * Consumer 接口表示执行在单个参数上的操作。
     */
    public void testConsumer() {
        Consumer<Person> greeter = (person -> System.out.println("hello," + person.firstName));
        greeter.accept(new Person("晋","阳"));
    }

    /**
     * Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法：
     */
    public void Comparator() {
        Comparator<Person> comparator = Comparator.comparing(p -> p.firstName);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        comparator.compare(p1, p2);
        // > 0
        comparator.reversed().compare(p1, p2);
        // < 0
    }

}
