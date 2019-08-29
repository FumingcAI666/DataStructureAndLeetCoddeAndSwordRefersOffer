package sword.refers.offer.demo;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author macfmc
 * @date 2019/8/30-0:13
 */
public class Pro13 {
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 2, 6, 7, 9, 10};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 相对位置不变->保持稳定性；奇数位于前面，偶数位于后面 ->判断，挪动元素位置；
     *
     * @param array
     */
    public static void reOrderArray(int[] array) {
        //相对位置不变，稳定性
        //插入排序的思想
        int m = array.length;
        //记录已经摆好位置的奇数的个数
        int k = 0;
        for (int i = 0; i < m; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                //j >= k+1
                while (j > k) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }
}
