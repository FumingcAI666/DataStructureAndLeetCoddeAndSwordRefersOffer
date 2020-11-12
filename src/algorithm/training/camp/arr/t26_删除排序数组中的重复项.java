package algorithm.training.camp.arr;

/**
 * @author macfmc
 * @date 2020/11/12-22:44
 */
public class t26_删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        // 边界判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 交换指针
        int len = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                len++;
            }
        }
        return len;
    }
}
