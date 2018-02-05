package org.java.practice.algorithm.minimum_spanning_tree.kruskal;

import org.java.practice.algorithm.minimum_spanning_tree.Edge;

import java.util.*;

/**
 * @author yang.jin
 * date: 11/01/2018
 * desc:
 */
public class Kruskal {

    public static void kruskal(String[] points, Edge[] edges) {
        //还可以这么sort的么
        Arrays.sort(edges);

        //把所有节点都放到sets里
        List<Set> sets = new ArrayList<>();
        for (int i=0;i<points.length;i++) {
            Set set = new HashSet();
            set.add(points[i]);
            sets.add(set);
        }

        //遍历边，从最小的边开始
        for (int i=0;i<edges.length;i++) {
            String start = edges[i].point1;
            String end = edges[i].point2;
            int counti = -1;
            int countj = -2;

            //遍历节点set
            for (int j=0;j<sets.size();j++) {
                Set set = sets.get(j);
                if (set.contains(start)) {
                    counti = j;
                }
                if (set.contains(end)) {
                    countj = j;
                }
            }

            if (counti < 0 || countj < 0) {
                System.out.println("没有在子树中找到节点，错误");
            }

            if (counti != countj) {
                System.out.println("输出start="+start+"||end="+end+"||w="+edges[i].cost);
                Set setj = sets.get(countj);
                sets.remove(countj);
                Set seti = sets.get(counti);
                sets.remove(counti);
                seti.addAll(setj);
                sets.add(seti);
            } else {
                System.out.println("他们在一颗子树中，不能输出start="+start+"||end="+end+"||w="+edges[i].cost);
            }
        }
    }
}
