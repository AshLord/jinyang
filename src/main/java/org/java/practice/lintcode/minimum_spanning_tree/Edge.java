package org.java.practice.lintcode.minimum_spanning_tree;

/**
 * @author yang.jin
 * date: 11/01/2018
 * desc:
 */
public class Edge implements Comparable{

    public String point1;

    public String point2;

    public int cost;

    public Edge(String point1, String point2, int cost) {
        this.point1 = point1;
        this.point2 = point2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        Edge to=(Edge)o;
        if (this.cost > to.cost) {
            return 1;
        } else if (this.cost == to.cost) {
            return 0;
        } else {
            return -1;
        }
    }
}
