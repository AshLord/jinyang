package org.java.practice.lintcode;

import java.util.Stack;

/**
 * Created by 晋阳 on 2018/1/1.
 */
public class 汉诺塔 {

    public static void main(String[] args) {
        int n = 5;
        汉诺塔[] towers = new 汉诺塔[3];
        for (int i = 0; i < 3; i++) towers[i] = new 汉诺塔(i);
        for (int i = n - 1; i >= 0; i--) towers[0].add(i);
        towers[0].moveDisks(n, towers[2], towers[1]);
        //print towers[0], towers[1], towers[2]
    }

    private Stack<Integer> disks;
    /*
    * @param i: An integer from 0 to 2
    */
    public 汉诺塔(int i) {
        // create three towers
        // write your code here
        disks = new Stack<Integer>();
    }

    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(汉诺塔 t) {
        // Move the top disk of this tower to the top of t.
        // Write your code here
        if (t.disks.isEmpty() || (!disks.isEmpty() && t.disks.peek() >= disks.peek())) {
            t.disks.push(disks.pop());
        }
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, 汉诺塔 destination, 汉诺塔 buffer) {
        // Move n Disks from this tower to destination by buffer tower
        // Write your code here
        if (n <= 0) {
            return;
        } else if (n == 1) {
            moveTopTo(destination);
        } else {
            this.moveDisks(n - 1, buffer, destination);
            System.out.println("将源塔前"+(n-1)+"个盘子都放到辅助塔中");

            this.moveDisks(1, destination, buffer);
            System.out.println("源塔的1个盘子放到目标塔中");

            buffer.moveDisks(n - 1, destination, this);
            System.out.println("再将辅助塔的"+(n-1)+"盘子放到目标塔上");
        }
    }

    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        // write your code here
        return disks;
    }
}

/**
 * Your Tower object will be instantiated and called as such:
 * Tower[] towers = new Tower[3];
 * for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
 * for (int i = n - 1; i >= 0; i--) towers[0].add(i);
 * towers[0].moveDisks(n, towers[2], towers[1]);
 * print towers[0], towers[1], towers[2]
 */
