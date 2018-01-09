package org.java.practice.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yang.jin
 * date: 09/01/2018
 * desc:
 */
public class 螺旋矩阵I {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        int[][] matrix3 = {{1, 2}, {3, 4}, {5, 6}};
        switch (0) {
            case 0:
                System.out.println(spiralOrder(matrix3));
                break;
            case 1:
                System.out.println();
                break;
            default:
                break;
        }
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        // 遍历当前行的首位置
        int lineStart = 0;
        // 遍历当前行的末位置
        int lineEnd = matrix[0].length;
        // 遍历当前列的首位置
        int columnStart = 0;
        // 遍历当前列的末位置
        int columnEnd = matrix.length;
        // 创建结果队列
        List<Integer> list = new LinkedList<>();
        // 遍历
        int flag = 0;
        while (list.size() < matrix.length * matrix[0].length) {
            if (flag == 0) {
                for (int i = lineStart; i < lineEnd; i++) {
                    list.add(matrix[columnStart][i]);
                }
                flag++;
                columnStart++;
            } else if (flag == 1) {
                for (int i = columnStart; i < columnEnd; i++) {
                    list.add(matrix[i][lineEnd - 1]);
                }
                lineEnd--;
                flag++;
            } else if (flag == 2) {
                for (int i = lineEnd; i > lineStart; i--) {
                    list.add(matrix[columnEnd - 1][i - 1]);
                }
                flag++;
                columnEnd--;
            } else if (flag == 3) {
                for (int i = columnEnd; i > columnStart; i--) {
                    list.add(matrix[i - 1][lineStart]);
                }
                flag -= 3;
                lineStart++;
            }
        }
        return list;
    }
}
