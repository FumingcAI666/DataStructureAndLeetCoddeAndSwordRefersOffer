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

    public static int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        return (int) Math.pow(2, target - 1);
    }

    public static int JumpFloorII1(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }
        return 2 * JumpFloorII(target - 1);
    }
}
