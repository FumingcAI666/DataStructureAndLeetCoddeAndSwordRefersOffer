package leetcode;

import java.util.Arrays;

/**
 * @author macfmc
 * @date 2020/3/20-23:41
 */
public class m3_20_m40 {
    public static void main(String[] args) {
        System.out.println(getLeastNumbers(new int[]{0, 1, 2, 1}, 1).toString());
        System.out.println(getLeastNumbers(new int[]{1, 2, 3}, 2).toString());
    }



    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] re = new int[k];
        for(int i = 0;i < k ;i++)
            re[i] = arr[i];
        return re;
    }
}
