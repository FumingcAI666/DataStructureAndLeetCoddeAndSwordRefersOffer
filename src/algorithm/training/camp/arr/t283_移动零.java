package algorithm.training.camp.arr;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @author macfmc
 * @date 2020/11/2-21:03
 */
public class t283_移动零 {

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes0(a);
        System.out.println(Arrays.toString(a));

        int[] b = {0, 1, 0, 3, 12};
        moveZeroes1(b);
        System.out.println(Arrays.toString(b));
    }

    /**
     * 向前移动
     *
     * @param nums
     */
    public static void moveZeroes0(int[] nums) {
        int i = 0;
        // 遍历数组
        for (int x : nums) {
            // 是否需要移动
            if (x == 0) {
                // 判断该指针前面是否有不为0的数
                int j = i;
                // 当j大于第二位且前面还有不为0数
                while (j >= 1 && nums[j - 1] != 0) {
                    // 交换顺序,向前移动一位
                    nums[j] = nums[j - 1];
                    nums[j - 1] = x;
                    j--;
                }
            }
            i++;
        }

    }

    /**
     * 向后移动
     * 时间复杂度:O(n),空间复杂度:O(1)
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        // 创建两个指针i和j，第一次遍历的时候指针b用来记录当前有多少非0元素。
        int b = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            // 即遍历的时候每遇到一个非0元素就将其往数组左边挪，第一次遍历完后，b指针的下标就指向了最后一个非0元素下标。
            if (0 != nums[i]) {
                nums[b] = nums[i];
                b++;
            }
        }
        // 第二次遍历的时候，起始位置就从b开始到结束，将剩下的这段区域内的元素全部置为0。
        for (int i = b; i < n; ++i) {
            nums[i] = 0;
        }
    }
}
