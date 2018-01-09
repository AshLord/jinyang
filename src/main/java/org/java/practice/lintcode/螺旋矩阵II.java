package org.java.practice.lintcode;

/**
 * @author yang.jin
 * date: 09/01/2018
 * desc:
 */
public class 螺旋矩阵II {

    public static void main(String[] args) {
        switch (1) {
            case 0:
                //妈的理解错题意了，我以为生成个矩阵就完了
                generateSimpleMatrix(3);
                break;
            case 1:
                //
                generateMatrix(3);
                break;
            default:
                break;
        }
    }

    public static int[][] generateMatrix(int n) {
        // write your code here
        //初始化矩阵
        int[][] metrix = new int[n][n];
        //将矩阵转化成一个x轴向右，y轴向下的x0y坐标轴，有助于思考
        int x_start = 1;
        int x_end = n;
        int y_start = 1;
        int y_end = n;
        int flag = 0;
        //i是准备插入正确位置的元素
        int i=1;
        while (i<=n*n) {
            switch (flag) {
                case 0:
                    for (int j=x_start;j<=x_end;j++) {
                        metrix[y_start-1][j-1] = i;
                        i++;
                    }
                    y_start++;
                    flag++;
                    break;
                case 1:
                    for (int j=y_start;j<=y_end;j++) {
                        metrix[j - 1][x_end - 1] = i;
                        i++;
                    }
                    x_end--;
                    flag++;
                    break;
                case 2:
                    for (int j=x_end;j>=x_start;j--) {
                        metrix[y_end - 1][j - 1] = i;
                        i++;
                    }
                    y_end--;
                    flag++;
                    break;
                case 3:
                    for (int j=y_end;j>=y_start;j--) {
                        metrix[j - 1][x_start - 1] = i;
                        i++;
                    }
                    x_start++;
                    flag -= 3;
                    break;
                default:
                    break;
            }
        }
        return metrix;
    }

    public static int[][] generateSimpleMatrix(int n) {
        // write your code here
        int[][] metrix = new int[n][n];
        for (int column = 1; column <= n; column++) {
            int j = column;
            int row = 0;
            while (row < n) {
                metrix[column - 1][row] = j;
                j = j + n;
                row++;
            }
        }
        return metrix;
    }
}
