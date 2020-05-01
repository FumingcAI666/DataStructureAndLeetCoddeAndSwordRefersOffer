package main.java.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组nums
 * 编写一个函数将所有0移动到数组的末尾
 * 同时保持非零元素的相对顺序
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 *  来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jackLinkai
 * @date 2020年4月29日23点09分
 */
public class Solution_283 {
    /**思路：
     * 设置一个index，表示非0数的个数，循环遍历数组，
     * 如果不是0，将非0值移动到第index位置,然后index + 1
     * 遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
     */
    public static int[] moveZeroes(int[] nums) {
        //如果该数组为空或只有一个数，则结束操作
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        //index统计非0数的个数
        int index = 0;
        //用增强for循环遍历数组，如果不为0，向前移动，把值为0的数排挤掉
        for (int num: nums) {
            if (num!= 0) {
                nums[index] = num;
                index++;
            }
        }
        //在非0数后面补上0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
    public static void main(String[] args) {
        int []a={0,1,0,3,12};
        int []b={0,0,0,4,6};
        int []c={2,5,0,0,7};
        int []d={1,0,2,0,0,8};
        System.out.println(Arrays.toString(moveZeroes(a)));
        System.out.println(Arrays.toString(moveZeroes(b)));
        System.out.println(Arrays.toString(moveZeroes(c)));
        System.out.println(Arrays.toString(moveZeroes(d)));
    }
}
