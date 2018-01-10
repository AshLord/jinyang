package org.java.practice.lintcode.hard;

/**
 * @author yang.jin
 * date: 10/01/2018
 * desc: 最小生成树——辅助类
 */
public class Connection {

    public String city1;

    public String city2;

    public int cost;

    public Connection(String city1, String city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }
}
