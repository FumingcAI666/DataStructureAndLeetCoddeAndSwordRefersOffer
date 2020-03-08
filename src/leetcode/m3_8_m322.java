package leetcode;

import java.util.Arrays;

import static java.lang.Math.min;

/**
 * @author macfmc
 * @date 2020/3/8-14:47
 */
public class m3_8_m322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
    }

    /**
     给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

     示例 1:
     输入: coins = [1, 2, 5], amount = 11
     输出: 3
     解释: 11 = 5 + 5 + 1

     示例 2:
     输入: coins = [2], amount = 3
     输出: -1

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/coin-change
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        // 填充数组
        Arrays.fill(f, amount + 1);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++)
                if (coins[j] <= i) {
                    f[i] = min(f[i], f[i - coins[j]] + 1);
                }
        }
        return f[amount] > amount ? -1 : f[amount];
    }
}
