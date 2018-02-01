package org.java.practice.algorithm;

import static org.java.practice.algorithm.InsertionSort.printArray;

public class QuickSort2 {

    public static void main(String[] args) {
        QuickSort2 test = new QuickSort2();
        int[] nums = {2, 1, 6, 7, 8, 5, 3, 5};
        quickSort(nums,0,nums.length-1);
        //quickSort2(nums,0,nums.length-1);
        printArray(nums);
    }

    private static void quickSort(int[] a, int begin, int end) {
        //
        int head = begin, tail = end;
        // 将第一个值作为快排序的分界值
        int pivot = a[begin];
        while (head < tail) {
            // 如果两个游标没有交集，或者后面一直大于或等于分界值就一直向前移动
            while (head < tail && a[tail] >= pivot) {
                --tail;
            }
            a[head] = a[tail];
            // 如果两个游标没有交集，或者前面是小于或等于分界值，就一直向后头移动
            while (head < tail && a[head] <= pivot) {
                ++head;
            }
            a[tail] = a[head];

        }
        // 将临界值赋值给游标的交集的地方
        a[head] = pivot;
        if (begin < tail) {
            // 递归排序游标的左边
            quickSort(a, begin, tail - 1);
        }
        if (head < end) {
            // 递归排序游标的右边
            quickSort(a, head + 1, end);
        }

    }

    private static void quickSort2(int[] nums, int begin, int end) {
        int tBegin = begin;
        int tEnd = end;
        //将第一个值作为快排的中轴
        int pivot = nums[begin];
        while (tBegin < tEnd) {
            //如果头尾指针没有交集，或者后面>=中轴，尾指针就一直向前移动
            while (tBegin < tEnd && nums[tEnd] >= pivot) {
                --tEnd;
            }
            nums[tBegin] = nums[tEnd];
            //如果头尾指针没有交集，或者前面<=中轴，头指针就一直向后移动
            while (tBegin < tEnd && nums[tBegin] <= pivot) {
                --tBegin;
            }
            nums[tEnd] = nums[tBegin];
        }
        //将中轴值塞到头尾指针交集的地方
        nums[tBegin] = pivot;
        if (begin < tEnd) {
            //递归 分治排序中轴左边
            quickSort2(nums, begin, tEnd - 1);
        }
        if (tBegin > end) {
            //递归 分治排序中轴右边
            quickSort2(nums, tBegin + 1, end);
        }
    }
}
