package sword.refers.offer.demo;

/**
 * 时间限制：1秒 空间限制：32768K
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成
 * 一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author macfmc
 * @date 2019/8/26-17:18
 */
public class Pro01 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(find(2, arr));
    }

    /**
     * 将二维数组进行二分查找
     *
     * @param target 目标数字
     * @param array  二维数组
     * @return
     */
    public static boolean find(int target, int[][] array) {/
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
