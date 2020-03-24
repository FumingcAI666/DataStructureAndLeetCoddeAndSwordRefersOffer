package leetcode;

/**
 * @author macfmc
 * @date 2020/3/21-11:20
 */
public class m3_21_365 {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(3, 5, 4));
    }

    /**
     有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
     如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。

     你允许：
     装满任意一个水壶
     清空任意一个水壶
     从一个水壶向另外一个水壶倒水，直到装满或者倒空
     示例 1: (From the famous "Die Hard" example)

     输入: x = 3, y = 5, z = 4
     输出: True
     示例 2:

     输入: x = 2, y = 6, z = 5
     输出: False
     */

    static int gcd(int x, int y) {
        if (y == 0) return x;
        int r = x % y;
        return gcd(y, r);
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || x == 0 || y == 0)
            return z == 0 || x + y == z;
        int n = gcd(x, y);
        return z == 0 || (z % n == 0 && x + y >= z);
    }

    boolean canMeasureWater1(int x, int y, int z) {
        if (z > (x + y))
            return false;
        if (z == 0 || x == 0 || y == 0)
            return z == 0 || x + y == z;
        int n = gcd(x, y);
        return z % n == 0;
    }
}
