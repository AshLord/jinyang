package org.java.practice.lintcode;

/**
 * @author yang.jin
 * date: 02/01/2018
 * desc:
 */
public class 硬币找零问题 {

    public static void main(String[] args) {
        makeChange(new int[]{1,5,10},3,20,new int[]{20,4,2});
    }

    /**
     * 硬币找零：动态规划题
     * @param values 保存每一种硬币的币值的数组
     * @param valueKinds 币值不同的硬币种类数量，即coinValue[]数组的大小
     * @param money 需要找零的面值
     * @param coinsUsed 保存面值为i的纸币找零所需的最小硬币数
     */
    public static void makeChange(int[] values, int valueKinds, int money, int[] coinsUsed) {

        coinsUsed[0] = 0;

        //对每一分钱都找零，即保存子问题的解以备用，即填表
        for (int cents=1;cents<=money;cents++) {
            //当用最小币值的硬币找零时，所需硬币数量最多
            int minCoins = cents;
            //遍历每一种面值的硬币，看是否可作为找零的其中之一
            for (int kind = 0;kind<valueKinds;kind++) {
                //若当前面值的硬币小于当前的cents则分解问题并查表
                if (values[kind] <= cents) {
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            //保存最小硬币数
            coinsUsed[cents] = minCoins;
            System.out.println("面值为"+cents+"的最小硬币数："+coinsUsed[cents]);
        }
    }
}
