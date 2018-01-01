package org.java.practice.lintcode;

import java.util.*;

/**
 * Created by 晋阳 on 2017/12/30.
 * 取两个数组的并集
 */
public class Intersection {

    public static void main(String[] args) {
        int[] nums1 = {61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,
                67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,
                42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};

        int[] nums2 = {5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,92,84,38,85,34,16,6,99,0,2,36,
                68,52,73,50,77,44,61,48};

        int[] nums3 = {1,1,2,2};

        int[] nums4 = {1,1,2,2};

        switch (10) {
            case 0:
                //错误的解法，不符合交集定义
                wrongResolution(nums1, nums2);
                break;
            case 1:
                //错误的解法2，尝试delete掉两个数组的并集元素
                wrongResolution2(nums1, nums2);
                break;
            case 2:
                //比较骚的解法，转成list去处理，但是却出现了CME
                bitchResolution(nums1, nums2);
                break;
            case 3:
                //尝试正确的解法（有个bug，当入参里包含-1时，这个bug会暴露出来）
                tryCorrectWay(nums1,nums2);
                break;
            case 4:
                //正确解法，但是自己想出来的这个办法时间复杂度太高了
                trulyOneAnswer(nums1, nums2);
                break;
            case 5:
                //尝试减少时间复杂度，尝试用JNI加速，但是还是不符合时间复杂度的要求
                tryReduceTime(nums1, nums2);
                break;
            case 6:
                //使用哈希来加速，但是把合法的重复元素给去掉了
                //实际上该方法时间复杂度为n的平方，在retainAll方法里面，第一次遍历目标List的所有元素，第二次contains方法
                //遍历原List的所有元素，内外两层循环。
                useHashSet(nums1, nums2);
                break;
            case 7:
                //先排序，后取交集
                sortAndGet(nums1, nums2);
                //同样也是先排序后取交集，这是一个用队列实现的版本，而且最神奇的是能实现取无重复交集！！
                //神奇个P！！MMP，居然用set存储结果，太Bitch了！
                testArrayIntersectionE(nums1, nums2);
                //来个去无重复交集的最终版本，终极无敌完美棒棒锤版本！
                break;
            case 8:
                //仿照6，使用list，尝试不删除合法重复元素，但是连不合法重复元素也给保留了
                useList(nums1, nums2);
            case 9:
                //最慢最笨的方法实现取无重复交集
                slowestWay(nums1, nums2);
            case 10:
                /** 终 极 完 美 答 案 */
                //取包含重复元素并集
                sortAndHashSet(nums1, nums2);
                //取无重复元素并集
                sortAndLinkedList(nums1, nums2);
            default:
                return;
        }

        System.out.println();
        //Result : 61 45 85 89 5 77 92 38 7 34 44 57 4 6 92 88 0 79
    }

    public static int[] sortAndLinkedList(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> resultList = new LinkedList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            int e1 = nums1[p1];
            int e2 = nums2[p2];
            if (e1 == e2) {
                resultList.add(e1);
                p1++;
                p2++;
            } else if (e1 > e2) {
                p2++;
            } else {
                p1++;
            }
        }

        int[] result = new int[resultList.size()];
        int i = 0;
        Iterator<Integer> iterator = resultList.iterator();
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }
        printArray(result);
        return result;
    }

    public static int[] sortAndHashSet(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        Set<Integer> resultSet = new HashSet<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            int e1 = nums1[p1];
            int e2 = nums2[p2];
            if (e1 == e2) {
                resultSet.add(e1);
                p1++;
                p2++;
            } else if (e1 > e2) {
                p2++;
            } else {
                p1++;
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (Integer val : resultSet) {
            result[i] = val;
            i++;
        }
        printArray(result);
        return result;
    }

    public static int[] testArrayIntersectionE(int[] nums1,int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        int sizeArrayA=nums1.length;
        int sizeArrayB=nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Queue<Integer> queueA=new PriorityQueue<Integer>(sizeArrayA);
        Queue<Integer> queueB=new PriorityQueue<Integer>(sizeArrayB);
        for(int i=0;i<sizeArrayA;i++){
            queueA.add(nums1[i]);
        }
        for(int i=0;i<sizeArrayB;i++){
            queueB.add(nums2[i]);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();

        while (!queueA.isEmpty()){
            Integer valueA=queueA.peek();
            Integer valueB=queueB.peek();
            if(null==valueA||null==valueB){
                break;
            }
            if(valueA.equals(valueB)){
                intersectionSet.add(valueA);
                queueA.poll();
                queueB.poll();
            }
            else if(valueA>valueB){
                queueB.poll();
            }
            else if(valueA<valueB){
                queueA.poll();
            }
        }

        int[] result = new int[intersectionSet.size()];
        int i = 0;
        for (Integer val : intersectionSet) {
            result[i] = val;
            i++;
        }

        printArray(result);
        return result;
    }

    private static int[] sortAndGet(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i=0;i<nums1.length;i++) {
            l1.add(nums1[i]);
        }
        for (int i=0;i<nums2.length;i++) {
            l2.add(nums2[i]);
        }
        List<Integer> intersection = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        for (;;) {
            if (l1.get(p1).equals(l2.get(p2))) {
                intersection.add(l1.get(p1));
                p1++;
                p2++;
            } else {
                if (l1.get(p1) > l2.get(p2)) {
                    p2++;
                } else {
                    p1++;
                }
            }
            if (p1 >= l1.size() || p2 >= l2.size()) {
                break;
            }
        }
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        printArray(result);
        return result;
    }

    private static int[] slowestWay(int[] nums1, int[] nums2) {

        Set<Integer> intersectionSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    intersectionSet.add(nums1[i]);
                }
            }
        }
        int[] result = new int[intersectionSet.size()];
        int i = 0;
        for (Integer val : intersectionSet) {
            result[i] = val;
            i++;
        }
        return result;

    }

    private static void useList(int[] nums1, int[] nums2) {
        // write your code here
        List<Integer> list1 = array2List(nums1);
        List<Integer> list2 = array2List(nums2);
        ArrayList list = new ArrayList<Integer>();
        list.addAll(list1);
        list.retainAll(list2);
        int[] result = new int[list.size()];
        int i = 0;
        for (Object val : list) {
            result[i] = (int) val;
            i++;
        }
        printArray(result);
    }

    private static void useHashSet(int[] nums1, int[] nums2) {
        // write your code here
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        for (int i=0;i<nums1.length;i++) {
            l1.add(nums1[i]);
        }
        for (int i=0;i<nums2.length;i++) {
            l2.add(nums2[i]);
        }
        HashSet set = new HashSet();
        set.addAll(l1);
        set.retainAll(l2);
        int[] result = new int[set.size()];
        int i = 0;
        for (Object val : set) {
            result[i] = (int) val;
            i++;
        }
    }

    private static List<Integer> array2List(int[] arr) {
        List<Integer> list = new ArrayList();
        for (int i=0;i<arr.length;i++) {
            list.add(arr[i]);
        }
        return list;
    }

    private static void tryReduceTime(int[] nums1, int[] nums2) {
        // write your code here
        int[] nums3 = new int[nums2.length];
        int counter = 0;
        for (int i = 0 ; i < nums1.length ; i ++) {
            int temp = nums1[i];
            for(int j = counter; j < nums2.length; j ++) {
                if (nums2[j] == temp) {
                    nums3[counter] = temp;
                    nums2[j] = nums2[counter];//并集元素不要了
                    counter++;
                    break;
                }
            }
        }
        int[] result = new int[counter];
        System.arraycopy(nums3,0,result,0,counter);
        printArray(result);
    }

    private static void trulyOneAnswer(int[] nums1, int[] nums2) {
        // write your code here
        int[] nums3 = new int[nums2.length];
        int counter = 0;
        for (int i = 0 ; i < nums1.length ; i ++) {
            int temp = nums1[i];
            for(int j = counter; j < nums2.length; j ++) {
                if (nums2[j] == temp) {
                    nums3[counter] = temp;
                    nums2[j] = nums2[counter];//并集元素不要了
                    counter++;
                    break;
                }
            }
        }
        int[] result = new int[counter];
        for (int i = 0;i<counter;i++) {
            result[i] = nums3[i];
        }

        printArray(result);
    }

    /**
     * 快接近真理了兄弟！
     * @param nums1
     * @param nums2
     */
    private static void tryCorrectWay(int[] nums1, int[] nums2) {
        // write your code here
        int[] nums3 = new int[nums2.length];
        int counter = 0;
        for (int i = 0 ; i < nums1.length ; i ++) {
            int temp = nums1[i];
            for(int j = 0; j < nums2.length; j ++) {
                if (nums2[j] == temp) {
                    nums3[counter] = temp;
                    counter++;
                    delete(j, nums2);
                    break;
                }
            }
        }
        int[] result = new int[counter];
        for (int i = 0;i<counter;i++) {
            result[i] = nums3[i];
        }

        printArray(result);
    }

    public static int[] delete(int index,int array[]){
        //根据删除索引，把数组后面的向前移一位
        for(int i=index;i<array.length;i++){
            if(i!=array.length-1){
                array[i]=array[i+1];
            }else{//处理最后一位超出情况
                array[i]=-1;
            }
        }
        return array;
    }

    /**
     * 事实证明：骚方法也行不通
     * @param nums1
     * @param nums2
     */
    private static void bitchResolution(int[] nums1, int[] nums2) {
        List<Integer> list1 = array2List(nums1);
        List<Integer> list2 = array2List(nums2);
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<list1.size();i++) {
            for (int j=0;j<list2.size();j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    list.add(list1.get(i));
                    list1.remove(i);
                    i--;
                    list2.remove(j);
                    j--;
                }
            }
        }
        for (Integer val : list) {
            System.out.print(val + " ");
        }
    }

    /**
     * 基于上一个错误的解法，我们只需要删除并集中的元素即可解决上一个遇到的问题
     * @param nums1
     * @param nums2
     */
    private static void wrongResolution2(int[] nums1, int[] nums2) {
        // write your code here
        int[] nums3 = new int[nums2.length];
        int counter = 0;
        for (int i = 0 ; i < nums1.length ; i ++) {
            int temp = nums1[i];
            for(int j = 0; j < nums2.length; j ++) {
                if (nums2[j] == temp) {
                    nums3[counter] = temp;
                    counter++;
                    delete(j, nums2);
                    delete(i, nums1);
                    break;
                }
            }
        }
        int[] result = new int[counter];
        for (int i = 0;i<counter;i++) {
            result[i] = nums3[i];
        }

        printArray(result);
    }

    /**
     * 错误的解法
     * 错在求交集的时候，如果一个数组里面有两个A数据，另一个数组里面只有一个A数据，最终结果里面却会包含2个，而根据
     * 交集的定义，结果中只应包含一个
     * @param nums1
     * @param nums2
     */
    private static void wrongResolution(int[] nums1, int[] nums2) {

        // write your code here
        int[] nums3 = new int[nums2.length];
        int counter = 0;
        for (int i = 0 ; i < nums1.length ; i ++) {
            int temp = nums1[i];
            for(int j = 0; j < nums2.length; j ++) {
                if (nums2[j] == temp) {
                    nums3[counter] = temp;
                    counter++;
                    break;
                }
            }
        }
        int[] result = new int[counter];
        for (int i = 0;i<counter;i++) {
            result[i] = nums3[i];
        }

        printArray(result);
    }


    public static void printArray(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void printArray(Integer[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
