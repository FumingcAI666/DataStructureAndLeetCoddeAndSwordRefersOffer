package algorithm.training.camp.arr;

/**
 * @author macfmc
 * @date 2020/11/2-22:18
 */
public class t70_爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs0(45));

        System.out.println(climbStairs1(45));
    }

    /**
     * 递归实现-leetcode-超出时间限制
     *
     * @param n
     * @return
     */
    public static int climbStairs0(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }
        return climbStairs0(n - 1) + climbStairs0(n - 2);
    }

    /**
     * 循环实现
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 2) {
            return n;
        }
        // num可能的方法 j1代表跳1层 j2代表跳2层
        int num = 0;
        int j1 = 1;
        int j2 = 2;
        // 循环累加
        for (int i = 3; i <= n; i++) {
            // 如果为三就是j1+j2
            num = j1 + j2;
            // 下次进入循环j1 就是j2
            j1 = j2;
            // j2 记录每次累加的状态
            j2 = num;
        }
        return num;
    }
}
