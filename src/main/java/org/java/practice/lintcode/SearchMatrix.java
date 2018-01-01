package org.java.practice.lintcode;

/**
 * Created by 晋阳 on 2018/1/1.
 * 写出一个高效的算法来搜索 m × n矩阵中的值。
 这个矩阵具有以下特性：
 每行中的整数从左到右是排序的。
 每行的第一个数大于上一行的最后一个整数。
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int[][] matrix2 = {{5}};
        int[][] matrix3 = {
                {1, 4, 8, 15, 20, 22, 25, 32, 36, 43, 49, 51, 53, 55, 59, 65, 69, 73, 80},
                {100, 116, 136, 148, 169, 188, 207, 222, 245, 266, 283, 299, 323, 347, 363, 384, 406, 431, 447},
                {460, 477, 494, 512, 532, 548, 562, 582, 604, 617, 630, 643, 663, 675, 690, 713, 735, 758, 783},
                {805, 819, 839, 855, 868, 878, 890, 909, 927, 941, 961, 971, 985, 1000, 1024, 1037, 1061, 1086, 1101},
                {1124, 1135, 1157, 1182, 1198, 1221, 1235, 1254, 1267, 1277, 1294, 1319, 1342, 1361, 1382, 1400, 1419, 1440, 1453},
                {1472, 1495, 1517, 1542, 1554, 1567, 1588, 1603, 1625, 1642, 1661, 1680, 1690, 1702, 1713, 1725, 1748, 1771, 1793}
        };
        //采用标准的排序指针查找算法，时间复杂度还是超了
        System.out.println(searchMatrix(matrix3, 1771));
        //九章算法给出的巧妙利用递增行和递减列实现快速查找
        System.out.println(bestWay(matrix3, 1472));
    }

    private static boolean bestWay(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return false;
        int row = 0;
        int col = matrix[0].length-1;
        // 注意下面两个while 循环 row  col 都要判断的
        while(row< matrix.length&& col>=0){
            while(row< matrix.length&& col>=0){
                if (matrix[row][col] == target){
                    return true;
                }else if(matrix[row][col] > target){
                    col--;
                }else{
                    row++;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int p1 = 0;
        if (matrix.length == 0) {
            return false;
        }
        while (p1 < matrix.length) {
            if (target > matrix[p1][0]) {
                if (p1 == matrix.length - 1) {
                    int p3 = 0;
                    while (p3 < matrix[p1].length) {
                        if (target == matrix[p1][p3]) {
                            return true;
                        } else if (target > matrix[p1][p3]) {
                            p3++;
                        } else {
                            return false;
                        }
                    }
                }
                p1++;
            } else if (target <= matrix[p1][0]) {
                //边界
                if (p1 == 0) {
                    return false;
                }
                //命中行matrix[p1-1]
                int p2 = 0;
                while (p2 < matrix[p1 - 1].length) {
                    if (target == matrix[p1 - 1][p2]) {
                        return true;
                    } else if (target > matrix[p1 - 1][p2]) {
                        p2++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
