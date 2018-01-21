package org.java.practice.jdk9;

import java.util.List;
import java.util.Set;

/**
 * @author yang.jin
 * date: 17/01/2018
 * desc:
 */
public class CollectionFactory {

    public static void main(String[] args) {
        Set<Integer> set = Set.of(1, 9, 9, 3, 1, 2, 3, 0);
        List<String> list = List.of("伊利丹", "卡德加", "维纶");
        //如果改变集合：UnsupportedOperationException
    }
}
