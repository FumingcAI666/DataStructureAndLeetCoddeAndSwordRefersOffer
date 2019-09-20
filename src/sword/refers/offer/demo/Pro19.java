package sword.refers.offer.demo;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @author macfmc
 * @date 2019/9/4-17:01
 */
public class Pro19 {
    /**
     * new一个数组 以便下面函数能调用
     */
    static ArrayList a = new ArrayList();

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(printMatrix(matrix));
        // [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
    }

    /**
     * 解题思路：顺时针打印就是按圈数循环打印，一圈包含两行或者两列，在打印的时候会出现某一圈中只包含一行，要判断从左向右打印
     * 和从右向左打印的时候是否会出现重复打印，同样只包含一列时，要判断从上向下打印和从下向上打印的时候是否会出现重复打印的情况
     *
     * @param matrix
     * @return
     */
    public static ArrayList printMatrix(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
        return a;
    }

    /**
     * 左上边界最多到达右下边界 用于判断是否还是剥圈打印
     *
     * @param m
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     */
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            //先判断是否只是一横行 如果是 打印该横行的列（通常用于内圈）
            for (int i = tC; i <= dC; i++) {
                a.add(m[tR][i]);
            }
        } else if (tC == dC) {
            //再判断是否只是一竖列 如果是 打印该横行的列（通常用于内圈
            for (int i = tR; i <= dR; i++) {
                a.add(m[i][tC]);
            }
        } else {
            //  用2个变量储存 用于判断当前位置
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                // 当前位置未到达当前行的最右列--》往右去
                a.add(m[tR][curC]);
                curC++;
            }
            while (curR != dR) {
                // 当前位置未到达当前列的最底行--》往下去
                a.add(m[curR][dC]);
                curR++;
            }
            while (curC != tC) {
                // 当前位置未到达当前行的最左列--》往左去
                a.add(m[dR][curC]);
                curC--;
            }
            while (curR != tR) {
                // 当前位置未到达当前列的最顶行--》往上去
                a.add(m[curR][tC]);
                curR--;
            }
        }
    }
}
