package algorithm.training.camp.arr;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * @author mac
 * @date 2020/11/12-23:08
 */
public class t189_旋转数组 {
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
     * 额外数组法 O(n)，空间复杂度O(1)
     *
     * @param nums 待移动数组
     * @param k    移动的位数
     */
    public void rotate1(int[] nums, int k) {
        // 创建一个等长度的数组
        int[] a = new int[nums.length];

        // 将需要放置的元素依次放入新数组
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        // 将新数组数据更新回老数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }


    /**
     * 旋转数组法
     *
     * @param nums 待移动数组
     * @param k    移动的位数
     */
    public void rotate(int[] nums, int k) {
        // nums=[1,2,3,4,5,6,7] k=2,此时k= %= nums.length = 4，也就是数据从0-4都要移动
        k %= nums.length;

        // 全部倒置 7,6,5,4,3,2,1
        reverse(nums, 0, nums.length - 1);

        // 倒置前半部分 6,7 5,4,3,2,1
        reverse(nums, 0, k - 1);

        // 倒置后半部分 6,7,1,2,3,4,5
        reverse(nums, k, nums.length - 1);
    }


    /**
     * 按照start和end倒置数组
     *
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums, int start, int end) {
        // 交换条件，果start>=end 就不需要交换了
        while (start < end) {
            // 报错需要交换的元素
            int temp = nums[start];
            // 交换顺序
            nums[start] = nums[end];
            nums[end] = temp;
            // 向中间移动
            start++;
            end--;
        }
    }
}
