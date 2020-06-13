package leetcode.offer;

/**
 * @author macfmc
 * @date 2020/6/13-22:36
 */
public class 面试题10I_斐波那契数列 {
    /**
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     */
    public int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n + 2)%1000000007;
    }


    public int fib1(int n) {
        if (n <= 1)
            return n;
        int[] result = new int[n + 1];
        result[1] = 1;
        for(int i = 2; i <= n; i++)
            result[i] = (result[i - 2] + result[i - 1])  % 1000000007;
        return result[n];
    }
}
