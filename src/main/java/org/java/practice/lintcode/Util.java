package org.java.practice.lintcode;

/**
 * @author yang.jin
 * date: 14/03/2018
 * desc:
 */
public final class Util<T> {

    public static void printDp(int[][] dp) {
        for (int[] e : dp) {
            for (int t : e) {
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }

    public static void printDp(boolean[][] dp) {
        for (boolean[] e : dp) {
            for (boolean t : e) {
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }
}
