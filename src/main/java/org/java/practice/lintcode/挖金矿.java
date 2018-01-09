package org.java.practice.lintcode;

import java.util.*;

/**
 * @author yang.jin
 * date: 02/01/2018
 * desc:    手把手学习动态规划
 */
public class 挖金矿 {

    public static void main(String[] args) {

        //9个金矿，二维数组第一列表示需要的人，第二列表示能挖出来多少金子
        int[][] mine = {
                {1000,8888},
                {1200,8329},
                {1300,8119},
                {1260,8339},
                {1980,8449},
                {1490,8939},
                {1220,8309},
                {1580,8489},
                {1760,8511}
        };

        int maxGold = digGold(mine, 10000,8);
        System.out.println(maxGold);
        int maxGold2 = digGoldMem(mine, 10000,8);
        System.out.println(maxGold2);
    }

    /**
     * 基于第一种解法，在递归的基础上加备忘录
     *
     * @param mine
     * @param people
     * @param mineNo
     * @return
     */
    private static Map<String, Integer> memo = new HashMap<>();
    private static int digGoldMem(int[][] mine,int people,int mineNo) {
        int result;

        if (memo.containsKey(people + ":" + mineNo)) {
            System.out.println("命中！"+people + ":" + mineNo);
            result = memo.get(people + ":" + mineNo);
        } else {
            //思考最小的子问题，只有一个矿的时候
            if (mineNo == 0) {
                if (people > mine[0][0]) {
                    //人数大于所需
                    result = mine[0][1];
                } else {
                    result = 0;
                }
            } else {
                //比如第2个矿
                //第一种情况：挖
                int yes = digGoldMem(mine, people - mine[mineNo][0], mineNo-1) + mine[mineNo][1];
                //第二种情况：不挖
                int no = digGoldMem(mine, people, mineNo-1);
                result = Math.max(yes, no);
            }
            memo.put(people + ":" + mineNo, result);
        }
        return result;
    }

    /**
     * 第一种解法：递归
     * @param mine
     * @param people
     * @param mineNo
     * @return
     */
    private static int digGold(int[][] mine,int people,int mineNo) {
        //思考最小的子问题，只有一个矿的时候
        if (mineNo == 0) {
            if (people > mine[0][0]) {
                //人数大于所需
                return mine[0][1];
            } else {
                return 0;
            }
        } else {
            //比如第2个矿
            //第一种情况：挖
            int yes = digGold(mine, people - mine[mineNo][0], mineNo-1) + mine[mineNo][1];
            //第二种情况：不挖
            int no = digGold(mine, people, mineNo-1);
            return Math.max(yes, no);
        }

    }

}
