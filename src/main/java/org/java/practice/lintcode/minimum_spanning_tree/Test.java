package org.java.practice.lintcode.minimum_spanning_tree;

import org.java.practice.lintcode.minimum_spanning_tree.kruskal.Kruskal;

/**
 * @author yang.jin
 * date: 11/01/2018
 * desc:
 */
public class Test {

    public static void main(String [] args){
        int [][] tree={
                {-1,6,1,5,-1,-1},
                {6,-1,5,-1,3,-1},
                {1,5,-1,5,6,4},
                {5,-1,5,-1,-1,2},
                {-1,3,6,-1,-1,6},
                {-1,-1,4,2,6,-1}
        };
        //MiniSpanTree.PRIM(tree, 0, 6);
        System.out.println("+++++++++++++++++++++++++++++++++");

        String[] points = {"A", "B", "C", "D", "E", "F"};
        Edge [] edges =new Edge[10];
        edges[0]=new Edge("A","B",6);
        edges[1]=new Edge("A","C",1);
        edges[2]=new Edge("A","D",5);
        edges[3]=new Edge("B","C",5);
        edges[4]=new Edge("B","E",3);
        edges[5]=new Edge("C","D",5);
        edges[6]=new Edge("C","E",6);
        edges[7]=new Edge("C","F",4);
        edges[8]=new Edge("D","F",2);
        edges[9]=new Edge("E","F",6);
        Kruskal.kruskal(points, edges);
    }

}
