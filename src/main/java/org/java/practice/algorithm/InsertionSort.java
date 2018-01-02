package org.java.practice.algorithm;

/**
 * @author yang.jin
 * date: 29/12/2017
 * desc: 直接插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};

        // 直接插入排序
        for (int high=0;high<array.length;high++) {
            //待插入元素
            int temp = array[high];
            int low;
            for (low=high-1;low>=0;low--) {
                //将大于temp的往后移动一位
                if (array[low] > temp) {
                    array[low + 1] = array[low];
                } else {
                    break;
                }
            }
            array[low + 1] = temp;
            printArray(array);
        }

    }

    public static void printArray(int[] array) {
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i]+",");
        }
        System.out.println();
    }
}
