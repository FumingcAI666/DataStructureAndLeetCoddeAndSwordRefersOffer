package cs.sort;

import java.util.Arrays;

/**
 * 类说明：归并排序
 */
public class MergeSort {
    public static int[] sort(int[] array) {
        if (array.length < 2) return array;
        /*切分数组，然后递归调用*/
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(sort(left), sort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)/*左边数组已经取完，完全取右边数组的值即可*/
                result[index] = right[j++];
            else if (j >= right.length)/*右边数组已经取完，完全取左边数组的值即可*/
                result[index] = left[i++];
            else if (left[i] > right[j])/*左边数组的元素值大于右边数组，取右边数组的值*/
                result[index] = right[j++];
            else/*右边数组的元素值大于左边数组，取左边数组的值*/
                result[index] = left[i++];
        }
        System.out.print("左子数组:");
        PrintArray.print(left);
        System.out.print("右子数组:");
        PrintArray.print(right);
        System.out.print("合并后数组:");
        PrintArray.print(result);
        System.out.println("--------------------");
        return result;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = MergeSort.sort(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
