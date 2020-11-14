package algorithm.training.camp.arr;

import java.util.Arrays;

/**
 * @author macfmc
 * @date 2020/11/14-16:03
 */
public class t88_合并两个有序数组 {

    /**
     * 合并后排序,时间复杂度O((n+m)log(n+m)),空间复杂度O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge0(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for (int i = m; i < n; i++) {
            if (index >= n) {
                break;
            }
            nums1[i] = nums2[index];
            index++;
        }
        Arrays.sort(nums1);
    }


    /**
     * 双指针,时间复杂度O(n+m),空间复杂度O(m)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null) {
            return;
        }

        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2. nums1_copy和nums2两个指针
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1 nums1设置为指针
        int p = 0;

        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        // 如果还有元素要添加，判断是num1_copy没循环完还是nums2没循环完
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m - p1);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, n - p2);
        }
    }

}
