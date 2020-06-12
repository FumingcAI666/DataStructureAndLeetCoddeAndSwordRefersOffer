package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author macfmc
 * @date 2020/6/12-22:58
 */
public class 面试题57II_和为s的连续正数序列 {
    /**
     * 暴力法，遍历数组
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        if (target <= 2) {
            return null;
        }

        // 遍历该数的前一半
        for (int i = 1; i < target / 2 + 1; i++) {
            int temp = target;
            int count = i;
            while (temp > 0) {
                temp = temp - count;
                count++;
            }
            if (temp == 0) {
                // 找到可以使数组为零的数的下标
                int[] arr = new int[count - i];
                int a = i;
                // 连续正整数
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = a;
                    a++;
                }
                res.add(arr);
            }
        }
        // 返回该数组
        return res.toArray(new int[0][]);
    }


    /**
     * 双指针 todo
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence1(int target) {
        ArrayList<int[]> res = new ArrayList<>();

        for (int i = 1; i <= target / 2; i++) {
            int sum = 0;
            int j = i;

            while (sum < target) {
                sum += j;
                j++;
            }

            if (sum == target) {
                int[] sol = new int[j - i];
                for (int k = 0; k < j - i; k++) {
                    sol[k] = k + i;
                }
                res.add(sol);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
