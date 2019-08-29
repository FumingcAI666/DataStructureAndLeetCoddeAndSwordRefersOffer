package sword.refers.offer.demo;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 *
 * @author macfmc
 * @date 2019/8/28-9:22
 */
public class Pro9 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
        System.out.println(JumpFloorII(4));
        System.out.println(JumpFloorII(5));
        System.out.println(JumpFloorII(6));
        System.out.println("-----------------");
        System.out.println(JumpFloorII1(3));
        System.out.println(JumpFloorII1(4));
        System.out.println(JumpFloorII1(5));
        System.out.println(JumpFloorII1(6));
    }

    /**
     * 每个台阶可以看作一块木板，让青蛙跳上去，n个台阶就有n块木板，最后一块木板是青蛙到达的位子， 必须存在，其他 (n-1) 块木板可以任意选择是否存在，则每个木板有存在和不存在两种选择，(n-1) 块木板 就有 [2^(n-1)] 种跳法，可以直接得到结果。
     * <p>
     * 其实我们所要求的序列为：0,1,2,4,8,16,……
     * 所以除了第一位外，其他位的数都是前一位的数去乘以2所得到的积。
     *
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        return (int) Math.pow(2, target - 1);
    }

    /**
     * 其他位的数都是前一位的数去乘以2所得到的积。
     *
     * @param target
     * @return
     */
    public static int JumpFloorII1(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }
        return 2 * JumpFloorII(target - 1);
    }
}
