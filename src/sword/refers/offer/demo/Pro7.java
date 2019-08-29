package sword.refers.offer.demo;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * @author macfmc
 * @date 2019/8/27-11:21
 */
public class Pro7 {

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(4));
        System.out.println(Fibonacci(5));
    }


    /**
     * 循环F[n]=F[n-1]+F[n-2] (n>=3,F[1]=1,F[2]=1)
     *
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        int preNum = 1;
        int prePreNum = 0;
        int result = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // 从2 开始计算到 n 相加
        for (int i = 2; i <= n; i++) {
            result = preNum + prePreNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }
}
