package leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author macfmc
 * @date 2020/6/11-19:47
 */
public class 面试题03_数组中重复的数字 {

    // 由于HashSet内部是HashMap的结构，其key-value的形式保证了数据的唯一性
    Set set = new HashSet<>();
    int result = -1;

    public static int findRepeatNumber1(int[] nums) {
        int temp;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 重头扫描数组，（假设为m),那么我们就拿与下标m的数字交换。在交换过程中，如果有重复的数字发生，那么终止返回ture
            if (nums[i] != i) {
                // 遇到下标为i的数字如果不是i的话
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 如果没有重复数字，那么正常交换后，数字i应该在下标为i的位置（实际上是把数组当做set）
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        findRepeatNumber1(new int[]{4, 1, 2, 3, 0});
    }

    public int findRepeatNumber(int[] nums) {
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果添加失败，证明该数已经在Set中了，返回该数即可
            if (!this.set.add(nums[i])) {
                this.result = nums[i];
                break;
            }
        }
        return result;
    }


}
