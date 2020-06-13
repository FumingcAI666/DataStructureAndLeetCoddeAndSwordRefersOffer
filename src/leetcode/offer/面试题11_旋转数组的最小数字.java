package leetcode.offer;

/**
 * @author macfmc
 * @date 2020/6/13-22:59
 */
public class 面试题11_旋转数组的最小数字 {

    /**
     * 暴力法 O(N)
     * 输入：[3,4,5,1,2]
     * 输出：1
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int temp = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            if (temp > numbers[i + 1])
                temp = numbers[i + 1];
        }
        return temp;
    }

    /**
     * 二分法  O(logN)
     *
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j])
                i = m + 1;
            else if (numbers[m] < numbers[j])
                j = m;
            else
                j--;
        }
        return numbers[i];
    }

}
