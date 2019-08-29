package sword.refers.offer.demo;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author macfmc
 * @date 2019/8/29-13:21
 */
public class Pro11 {
    public static void main(String[] args) {
        //使用n=10,二进制形式为1010，则1的个数为2；
        int n = -10;
        System.out.println(n + "的二进制中1的个数：" + NumberOf1(n));
    }

    /**
     * 一个二进制数1100，1100减1得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再把原来的整数和减去1之后的结果做与运算，
     * 从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000。
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }
}
