package leetcode;

/**
 * @author macfmc
 * @date 2020/3/24-22:50
 */
public class m3_24_m1716 {
    /**
     一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     注意：本题相对原题稍作改动
     示例 1：
     输入： [1,2,3,1]
     输出： 4
     解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/the-masseuse-lcci
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */
    /*
1. 如果我们接第n个预约的话，由于相邻的预约不能接，所以dp[n] = dp[n - 2] + nums[n]（即等于到第n-2个预约的最大时长 + 第n个预约的时长）； 2. 反之如果我们不接第n个预约的话，那么dp[n] = d[n - 1]（即等于到第n - 1个预约的最大时长）。

于是，我们得到了状态转移方程：dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
    */
    /*
    public int massage(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
    */
    public int massage(int[] nums) {
        int n = nums.length;
        // 处理边界条件。
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // 定义dp数组，按照状态转移方程递推。
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

}
