package sword.refers.offer.demo;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author macfmc
 * @date 2019/8/26-18:09
 */
public class Pro06 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(minNumberInRotateArray(arr));
    }


    /**
     * 一个局部排好序的列表,线性查询最小元素
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int res = 0;
        // 线性查询，找小的，找不到就是第一个
        for (int i = 0; i < len - 1; i++) {
            if (array[i] > array[i + 1]) {
                res = array[i + 1];
                return res;
            }
        }
        return array[0];
    }
}
