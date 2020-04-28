package leetcode;

/**
 * @author macfmc
 * @date 2020/4/28-23:07
 */
public class m_283 {
    /**
     * 我们创建两个指针i和j，第一次遍历的时候指针b用来记录当前有多少非0元素。
     * 即遍历的时候每遇到一个非0元素就将其往数组左边挪，第一次遍历完后，b指针的下标就指向了最后一个非0元素下标。
     * 第二次遍历的时候，起始位置就从b开始到结束，将剩下的这段区域内的元素全部置为0。
     * 时间复杂度:O(n),空间复杂度:O(1)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int b = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (0 != nums[i]) {
                nums[b] = nums[i];
                b++;
            }
        }

        for (int i = b; i < n; ++i) {
            nums[i] = 0;
        }
    }
}
