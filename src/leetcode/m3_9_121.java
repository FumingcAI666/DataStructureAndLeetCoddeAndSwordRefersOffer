package leetcode;

/**
 * @author macfmc
 * @date 2020/3/9-11:31
 */
public class m3_9_121 {
    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{1,2}));
    }
    /**
     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

     如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

     注意你不能在买入股票前卖出股票。

     示例 1:

     输入: [7,1,5,3,6,4]
     输出: 5
     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     示例 2:

     输入: [7,6,4,3,1]
     输出: 0
     解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = prices.length-1; i >= 0; i--)
            for (int j = i; j >= 0; j--) {
                int num = prices[i] - prices[j];
                if (num > 0 && num > max)
                    max = num;
            }
        return max;
    }


    public static int maxProfit1(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        // 每天的最大收益
        for (int i = 0; i < prices.length; i++) {
            // 如果比他小就下一个
            if (prices[i] < minprice)
                minprice = prices[i];
                // 如果比他大就保存差值
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
