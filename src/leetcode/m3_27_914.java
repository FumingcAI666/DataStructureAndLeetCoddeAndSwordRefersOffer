package leetcode;

/**
 * @author macfmc
 * @date 2020/3/27-0:37
 */
public class m3_27_914 {
    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1})); //true
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3})); //false
        System.out.println(hasGroupsSizeX(new int[]{1})); //false
        System.out.println(hasGroupsSizeX(new int[]{1, 1})); //true
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2})); //true
        System.out.println(hasGroupsSizeX(new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2})); //true
    }


    /**
     914. 卡牌分组
     给定一副牌，每张牌上都写着一个整数。

     此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

     每组都有 X 张牌。
     组内所有的牌上都写着相同的整数。
     仅当你可选的 X >= 2 时返回 true。



     示例 1：

     输入：[1,2,3,4,4,3,2,1]
     输出：true
     解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     示例 2：

     输入：[1,1,1,2,2,2,3,3]
     输出：false
     解释：没有满足要求的分组。
     示例 3：

     输入：[1]
     输出：false
     解释：没有满足要求的分组。
     */
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        // 统计频率
        int[] freq = new int[10000];
        for (int num : deck) freq[num]++;

        // 默认最大公约数为第一个数字的
        int gcd = freq[deck[0]];
        for (int f : freq) {
            if (f == 0) continue;

            // 不断求最大公约数并更新
            gcd = gcd(gcd, f);

            // 没有最大公约数
            if (gcd == 1) return false;
        }
        return true;
    }

    // 求两数的最大公约数
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
