package algorithm.training.camp.arr;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * @author macfmc
 * @date 2020/11/14-9:51
 */
public class t1122_数组的相对排序 {

    public static void main(String[] args) {

    }

    /**
     * @param arr1 待排序数组
     * @param arr2 排序规则数组
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length];
        int a = 0;

        // O(k*n) 双重循环，把符合条件的数据放入新数组，老数组置位-1
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    arr[a] = arr1[j];
                    a++;
                    arr1[j] = -1;
                }
            }
        }

        // 如果arr1中没有出现arr2中出现的数据，直接返回
        int k = arr1.length - (a + 1);
        if (k <= 0) {
            return arr;
        }

        // 从小到大排序
        Arrays.sort(arr1);

        // 不是-1的数据继续set到新数组
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != -1) {
                arr[a] = arr1[i];
                k++;
                a++;
            }
        }
        return arr;
    }

    /**
     * @param arr1 待排序数组
     * @param arr2 排序规则数组
     * @return arr 新数组
     */
    public int[] relativeSortArray0(int[] arr1, int[] arr2) {
        int[] nums = new int[1001];
        int[] arr = new int[arr1.length];

        // 遍历arr1,统计每个元素的出现的次数
        for (int i : arr1) {
            nums[i]++;
        }

        // 遍历arr2,把arr2中出现的记录在arr新数组里
        int a = 0;
        for (int i : arr2) {
            while (nums[i] > 0) {
                arr[a++] = i;
                nums[i]--;
            }
        }

        // 遍历nums,处理剩下arr2中未出现的元素
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0) {
                arr[a++] = i;
                nums[i]--;
            }
        }
        return arr;
    }
}
