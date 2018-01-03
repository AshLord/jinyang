package org.java.practice.lintcode;

/**
 * @author yang.jin
 * date: 03/01/2018
 * desc:
 */
public class DropEggIII {

    /**
     * @Title: main
     * @Description: 测试
     * @param args
     * @return void
     * @throws
     */
    public static void main(String[] args) {

        int n = 2;
        int k = 5;
        int m = 100;

        //System.out.println("利用递归求解扔鸡蛋问题结果为：" + eggDroppingRecursion(n, k));
        //System.out.println("利用动态规划求解扔鸡蛋问题结果为：" + eggDropping(n, k));
        System.out.println("利用动态规划求解扔鸡蛋问题结果为：" + eggDropping(n, m));

    }

    /**
     *
     * @Title: eggDroppingRecursion
     * @Description: 递归方式求解问题
     * @param eggs  鸡蛋数
     * @param floors  楼层数
     * @return
     * @return int
     */
    public static int eggDroppingRecursion(int eggs, int floors){
        //边界条件判断
        if(floors == 1 || floors == 0)
            return floors;
        //如果只有一个鸡蛋，最坏的情况下是k次测试，一层层
        if(eggs == 1)
            return floors;

        int min = 65535;
        int res;

        //考虑从第一层到第k层扔下鸡蛋的所有情况的最小结果
        for(int i = 1; i <= floors; i++){
            res = Math.max(eggDroppingRecursion(eggs-1, i-1), eggDroppingRecursion(eggs, floors-i));
            if(res < min)
                min = res;
        }
        return min+1;
    }
    //上面的程序问题是复杂度太大 O(2^k)。如果k=36的话，基本是跑不出结果。

    public static int eggDropping(int eggs, int floors){
        //构建状态转移矩阵
        //eggFloor[i][j] 表示对于 i个鸡蛋 j 层楼，需要的最少测试次数
        int[][] tc = new int[eggs+1][floors+1];

        //初始化状态转移矩阵
        //只有1层楼或0层楼时
        for(int i = 0; i <= eggs; i++){
            tc[i][1] = 1;
            tc[i][0] = 0;
        }
        //只有一个鸡蛋时
        for(int j = 1; j <= floors; j++){
            tc[1][j] = j;
        }

        //构建状态转移矩阵
        //遍历用了i个鸡蛋的情况
        for(int egg = 2; egg <= eggs; egg++){
            //遍历一共试了在j层楼扔鸡蛋的情况
            for(int topFloor = 2; topFloor <= floors; topFloor++){

                tc[egg][topFloor] = Integer.MAX_VALUE;
                for(int currFloor = 1; currFloor <= topFloor; currFloor++){
                    /*if(res < tc[egg][topFloor])
                        tc[egg][topFloor] = res;*/
                    tc[egg][topFloor] = Math.min(1 + Math.max(tc[egg-1][currFloor-1], tc[egg][topFloor-currFloor]), tc[egg][topFloor]);
                }

            }
        }
        return tc[eggs][floors];
    }

    /**
     * 最优子结构
     * k ==> 楼层数
     n ==> 鸡蛋数
     eggDrop(n, k) ==>最少需要的测试次数(考虑所有情况)
     eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)):
     x 属于 {1, 2, ..., k}}
     */
}
