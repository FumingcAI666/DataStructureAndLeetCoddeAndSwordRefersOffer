package algorithm.training.camp.arr;

/**
 * @author macfmc
 * @date 2020/11/12-23:08
 */
public class t89_旋转数组 {
    /**
     * 暴力法 O(k*n)
     *
     * @param nums 待移动数组
     * @param k    移动的位数
     */
    public void rotate0(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            // 待移动的 K位 数据
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                // 保存移动位的数据
                temp = nums[j];
                // 将末尾移动到 移动位
                nums[j] = previous;
                // 将带移动的数据保存至下一循环
                previous = temp;
            }
        }
    }

    /**
     * 额外数组 O(n)，空间复杂度O(1)
     *
     * @param nums 待移动数组
     * @param k    移动的位数
     */
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
