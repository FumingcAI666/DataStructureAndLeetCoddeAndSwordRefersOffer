package leetcode.offer;

/**
 * @author macfmc
 * @date 2020/6/13-22:53
 */
public class 面试题10II_青蛙跳台阶问题 {

    /**
     * 递归实现
     * @param n
     * @return
     */
    public int numWays1(int n) {
        if (n <= 1)
            return 1;
        if (n < 3)
            return n;
        return numWays(n - 1) + numWays(n + 2) % 1000000007;
    }

    /**
     * 数组实现（保存子操作）
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n <= 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

}
