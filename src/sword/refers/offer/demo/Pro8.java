package sword.refers.offer.demo;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author macfmc
 * @date 2019/8/28-9:20
 */
public class Pro8 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(2));
        System.out.println(JumpFloor(3));
        System.out.println(JumpFloor(4));
        System.out.println(JumpFloor(5));
    }

    /**
     * 斐波那契数列 F[n]=F[n-1]+F[n-2] (n>=3,F[1]=1,F[2]=1)
     *
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        if (1 == target || 2 == target) {
            return target;
        }
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 0; i < target - 2; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

}
