package org.java.practice.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang.jin
 * date: 02/01/2018
 * desc:There is a building of n floors. If an egg drops from the k th floor or above, it will break. If it‘s dropped from any floor below, it will not break.
You‘re given m eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the worst case.
Example
Given m = 2, n = 100 return 14
Given m = 2, n = 36 return 8
 */
public class 扔鸡蛋II {

    public static void main(String[] args) {
        switch (3) {
            case 0:
                System.out.println(dropEggs2Standard(2, 100));
                break;
            case 1:
                System.out.println(anotherThought(2,100));
                break;
            case 2:
                //自己的土办法，循环+递归+备忘录，81% 数据通过测试，AC不了
                System.out.println(myStupidSolution(2,100));
                break;
            case 3:
                //自己实现动态规划！加油
                System.out.println(myOwnDp(2,100));
                break;
            default:
                break;
        }
    }

    private static int myOwnDp(int eggs, int floors) {

        //第一步永远是创建动态规划的备忘录,也叫状态转移矩阵
        //记住：二维数组里的length是0-start的，又因为包含层数为0或鸡蛋为0的情况，所以定义行高和列宽的时候自然要加1
        int[][] state = new int[eggs + 1][floors + 1];

        //第二步永远是考虑边界，也就是初始化动态规划的备忘录
        //先考虑eggs的边界
        for (int i=0;i<=floors;i++) {
            //首先是eggs=0的情况
            state[0][i] = 0;
            //然后是eggs=1的情况
            //eggs=1的时候，肯定是从第0层一直往上实验
            state[1][i] = i;
        }
        //再考虑floors的边界
        for (int i=1;i<=eggs;i++) {
            //首先是floors=0的情况
            state[i][0] = 0;
            //然后是floors=1的情况
            state[i][1] = 1;
        }

        //第三步就是动态规划方程了
        //找递推过程中的两个紧邻步骤之间的关系，如何由子结果得到母结果
        //首先，鸡蛋要从2个开始算，因为0个和1个情况你已经考虑完了
        for (int egg=2;egg<=eggs;egg++) {
            //楼层有多高要从2层起步，因为0层和1层的情况你也考虑完了
            for (int floor=2;floor<=floors;floor++) {
                //看这里！这里就是你还有egg个鸡蛋，一共有floor层的子问题！
                //这里定义一个变量来存储最终结果，找到在哪层扔能达到所扔次数最少的目标，扔鸡蛋次数多了胳膊会酸！
                int result = Integer.MAX_VALUE;
                for (int drop=1;drop<=floor;drop++) {
                    //这里！就是在当前子问题中，你从第drop层扔鸡蛋的情况！
                    //第一种情况，哎呀~碎了！那么剩下的问题就转化成了如何在drop-1层，用egg-1个鸡蛋寻找最优解
                    int broken = state[egg - 1][drop - 1];
                    //第二种请看，卧槽~没碎！问题就转化成了如果再floos-drop层，用egg个鸡蛋寻找最优解
                    int unbroken = state[egg][floor - drop];
                    //两种情况我肯定要取最大值，因为我根本不确定鸡蛋会不会碎，我特么又不是先知！
                    int condition = Math.max(broken, unbroken) + 1;
                    //不断的和上一次的结果做比较，只为得到最优的结果，最少的扔鸡蛋次数！
                    result = Math.min(condition, result);
                }
                //当前子问题（当我有egg个鸡蛋，一共有floor层时）已经for循环完了！撒花~~接下来，就是把结果存到我们的结果矩阵里了！
                state[egg][floor] = result;
            }
        }

        //以上的步骤在不断的往状态矩阵（我把它称作装满结果的大盘子！）填充结果！到这里已经都填充完毕，我们自然就可以取到我们想要的结果啦！
        return state[eggs][floors];
    }

    /**
     * @param m 鸡蛋
     * @param n 层数
     * @return
     */
    public static Map<String,Integer> map = new HashMap<>();
    public static int myStupidSolution(int m, int n) {
        if (map.containsKey(m + "&" + n)) {
            return map.get(m + "&" + n);
        } else {
            if(m == 1)
                return n;
            if(n == 1 || n == 0)
                return n;
            int result = Integer.MAX_VALUE;
            for (int currFloor = 1;currFloor<n;currFloor++) {
                //第一种情况：碎了
                int broke;
                if (currFloor - 1 == 0) {
                    broke = 1;
                } else {
                    broke = myStupidSolution(m - 1, currFloor - 1);
                }
                //第二种情况：没碎
                int whole;
                if (n - currFloor == 0) {
                    whole = 1;
                } else {
                    whole = myStupidSolution(m, n - currFloor);
                }
                result = Math.min(Math.max(broke, whole) + 1, result);
            }
            map.put(m + "&" + n, result);
            return result;
        }
    }

    /**
     * 实现思路：
     *  动态规划+递归。用二元数组存储某鸡蛋某层所需的次数。迭代试扔第一个鸡蛋，在某层扔。
     *  1.扔碎了即转为鸡蛋少一个，楼层少一层的子问题。
     *  2.没扔碎即转化为鸡蛋没有少楼层少为上半层那么多的子问题。
     * @param eggs m个鸡蛋
     * @param floors n层楼
     * @return
     */
    public static int dropEggs2Standard(int eggs, int floors) {
        // write your code here
        int[][] dp = new int[eggs + 1][floors + 1];

        for (int i = 1; i <= eggs; i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int j = 1; j <= floors; j++){
            dp[1][j] = j;
        }

        for (int i = 2; i <= eggs; i++){
            for (int j = 2; j <= floors; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 1; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j],
                            1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]));
                }
            }
        }
        return dp[eggs][floors];
    }

    public static int anotherThought(int eggs, int floors) {
        // Write your code here
        int[][] state = new int[floors + 1][eggs + 1];
        for (int i = 1; i < eggs + 1; i++) {
            state[1][i] = 1;
        }
        for (int i = 1; i < floors + 1; i++) {
            state[i][1] = i;
        }
        for (int i = 2; i < floors + 1; i++) {//n ---> floor
            for (int j = 2; j < eggs + 1; j++) {//m ---> eggs
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < i + 1; k++) {
                    min = Math.min(Math.max(state[k - 1][j - 1], state[i - k][j]),min);
                }
                state[i][j] = min + 1;
            }
        }
        return state[floors][eggs];
    }



}
