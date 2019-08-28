package sword.refers.offer.demo;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author macfmc
 * @date 2019/8/28-16:33
 */
public class Pro10 {

    public static void main(String[] args) {
        System.out.println(RectCover(2));
        System.out.println(RectCover(3));
        System.out.println(RectCover(4));
        System.out.println(RectCover(5));
        System.out.println(RectCover(6));
    }

    public static int RectCover(int target) {
        if (target < 1) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        int n1 = 1, n2 = 2;
        int n3 = n1 + n2;
        while (target-- != 2) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}
