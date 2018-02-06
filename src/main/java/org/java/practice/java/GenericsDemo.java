package org.java.practice.java;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author yang.jin
 * date: 06/02/2018
 * desc:
 */
public class GenericsDemo {

    public static void main(String[] args) {

    }

    public <T> boolean contains(T[] arr, T x) {
        for (T val : arr) {
            if (val.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public <T extends Comparable<? super T>> T findMax(T[] arr) {
        int maxIndex = 0;
        for (int i=1;i<arr.length;i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    /*public <T extends Comparable<T>> T findMax(T[] arr) {

        T max = arr[0];
        Arrays.stream(arr).forEachOrdered(e -> {
            if (e.compareTo(max) > 0){
                max = e;
            }
        });
    }*/

}
