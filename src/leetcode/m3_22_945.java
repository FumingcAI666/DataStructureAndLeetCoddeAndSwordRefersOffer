package leetcode;

import java.util.Arrays;

/**
 * @author macfmc
 * @date 2020/3/22-19:11
 */
public class m3_22_945 {
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(minIncrementForUnique(new int[]{1,1,2,2,3,7}));
    }
    /**
     给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
     返回使 A 中的每个值都是唯一的最少操作次数。

     示例 1:
     输入：[1,2,2]
     输出：1
     解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
     示例 2:
     输入：[3,2,1,2,1,7]
     输出：6
     解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
     可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
     提示：

     1,1,2,2,3,7
     2   3  4
     0 <= A.length <= 40000
     0 <= A[i] < 40000
     */

    public static int minIncrementForUnique(int[] A) {
        Arrays.sort(A);

        int num = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= A[i]) {
                int a = A[i - 1] - A[i] + 1;
                num = num + a;
                A[i] = A[i] + a;
            }
        }
        return num;
    }


}
