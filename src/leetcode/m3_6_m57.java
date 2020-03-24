package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author macfmc
 * @date 2020/3/6-15:46
 */
public class m3_6_m57 {
    public static void main(String[] args) {
        int[][] a = findContinuousSequence(15);
        /**
         * 打印数组
         */
        System.out.println(Arrays.deepToString(a));
    }

    /**
     输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

     序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

      
     示例 1：
     输入：target = 9
     输出：[[2,3,4],[4,5]]

     示例 2：
     输入：target = 15
     输出：[[1,2,3,4,5],[4,5,6],[7,8]]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < target / 2 + 1; i++) {
            int sum = 0;
            int j = i;
            while (sum < target) {
                sum += j;
                j++;
            }
            if (sum == target) {
                int t = i;
                int[] temp = new int[j - i];
                for (int k = 0; k < temp.length; k++) {
                    temp[k] = t;
                    t++;
                }
                list.add(temp);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
