package org.java.practice.algorithm;

import static org.java.practice.algorithm.InsertionSort.printArray;

/**
 * @author yang.jin
 * date: 29/12/2017
 * desc: 二分法排序
 */
public class BinaryInsertionSort {

    public static void main(String[] args) {

        int[] a={49,38,97,65,176,213,227,49,78,34,12,164,11,18,1};

        //二分插入排序
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(temp<a[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= left; j--) {
                a[j+1] = a[j];
            }
            if(left != i){
                a[left] = temp;
            }
            printArray(a);
        }

    }

}
