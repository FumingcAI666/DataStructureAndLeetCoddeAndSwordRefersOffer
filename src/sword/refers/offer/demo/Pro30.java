package sword.refers.offer.demo;

/**
 * 连续子数组的最大和
 * 题目描述
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(0到3)。给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
 *
 * @author macfmc
 * @date 2019/9/20-10:41
 */
public class Pro30 {
    public static void main(String[] args) {
        int[] a = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSubSum1(a));
        System.out.println(maxSubSum2(a));
        System.out.println(maxSubSum3(a));
        System.out.println(maxSubSum4(a));
    }

    /**
     * 使用动态规划 O(N)
     *
     * @param a
     * @return
     */
    private static int maxSubSum4(int[] a) {
        //记录当前所有子数组的和的最大值
        int res = a[0];
        //包含array[i]的连续数组最大值
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max + a[i], a[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    /**
     * 它把这一组数分成前一半和后一半，再分别针对这两部分处理（分治法）
     * 显而易见：最大子序列和必定是前一段或者后一段或者前后中间这一段这三者之一，再利用递归循环计算
     * 注：代码是越短越好，但是算法未必，这种算法也许很长，但是相比前两种算法它更优秀,O(NlogN)
     *
     * @param a
     * @return
     */
    private static int maxSubSum3(int[] a) {
        // 递归初始化参数
        return maxSumRec(a, 0, a.length - 1);
    }

    private static int maxSumRec(int[] a, int left, int right) {
        // 判断是否只有一个元素
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        // 左端处理
        int maxLeftBorderSum = 0;
        int leftBoarderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBoarderSum += a[i];
            if (leftBoarderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBoarderSum;
            }
        }

        // 右端处理
        int maxRightBoarderSum = 0;
        int rightBoarderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBoarderSum += a[i];
            if (rightBoarderSum > maxRightBoarderSum) {
                maxRightBoarderSum = rightBoarderSum;
            }
        }
        // 返回最大值
        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBoarderSum);

    }

    /**
     * 在第一种的基础上简化，撤除一层for循环，运行时间O(N^2)
     *
     * @param a
     * @return
     */
    private static int maxSubSum2(int[] a) {
        int maxSum = -1;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 穷举所有可能，由于嵌套三层for循环，运行时间O(N^3)
     *
     * @param a
     * @return
     */
    private static int maxSubSum1(int[] a) {
        int maxSum = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }
}
