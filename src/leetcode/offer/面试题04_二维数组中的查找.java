package leetcode.offer;

/**
 * @author macfmc
 * @date 2020/6/11-22:57
 */
public class 面试题04_二维数组中的查找 {


    /**
     * 暴力解发 n^2
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                if (matrix[i][j] == target)
                    return true;
        return false;
    }


    /**
     * 线性解法 O(M+N)
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        //右上角
        if (matrix == null || matrix.length == 0)
            return false;
        int i = 0, j = matrix[0].length - 1;


        while (j >= 0 && i < matrix.length) {
            if (matrix[i][j] < target)
                i++;
            else if (matrix[i][j] > target)
                j--;
            else
                return true;
        }
        return false;

        //左下角
        // int i = matrix.length - 1, j = 0;
        // while(i >= 0 && j < matrix[0].length)
        // {
        //     if(matrix[i][j] > target) i--;
        //     else if(matrix[i][j] < target) j++;
        //     else return true;
        // }
        // return false;
    }


}
