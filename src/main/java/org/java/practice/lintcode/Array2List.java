package org.java.practice.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by 晋阳 on 2017/12/30.
 */
public class Array2List {

    @Deprecated
    public static List array2ListFalse(int[] array) {
        return Arrays.asList(array);
    }

    public static List array2List(int[] array) {
        // To boxed list
        // To boxed list
        List<Integer> you  = Arrays.stream( array ).boxed().collect( Collectors.toList() );
        List<Integer> like = IntStream.of( array ).boxed().collect( Collectors.toList() );
        return like;
    }

    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        List<String> list = Arrays.asList(array);
        System.out.println(list.get(0));

        Integer[] array1 = {0, 1, 2};
        List<Integer> list1 = Arrays.asList(array1);
        System.out.println(list1.get(0));

        // java 的基本类型不支持asList
        int[] array2 = {0, 1, 2};
        List list2 = Arrays.asList(array2);
        System.out.println(list2.get(0));
    }
}
