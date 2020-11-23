package algorithm.training.camp.arr;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author macfmc
 * @date 2020/11/23-14:47
 */
public class t452_用最少数量的飞镖扎爆气球 {
    /**
     * 用气球头升序（用气球尾排序也类似）
     *
     * @param points
     * @return count
     */
    public int findMinArrowShots0(int[][] points) {
        // 特殊情况不作处理，返回0
        if (points == null || points.length < 1 || points[0].length <= 1) {
            return 0;
        }

        // 飞镖数量（不能形成交集的集合数量）
        int count = 1;

        // 把数组升序排序
        // Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        // Arrays.sort(points, (a, b) -> (a[0] == b[0]) ? (a[1] > b[1] ? 1 : -1) : (a[0] > b[0] ? 1 : -1));
        Arrays.sort(points, (int[] a, int[] b) -> (a[0] < b[0]) ? -1 : 1);

        // 气球的头和气球尾巴
        int start = points[0][0], end = points[0][1];

        for (int i = 1; i < points.length; ++i) {
            // 如果如果有交集
            if (points[i][0] <= end) {
                // 找交集（最大的头，和最小的尾巴）
                start = Math.max(points[i][0], start);
                end = Math.min(points[i][1], end);
            } else {
                // 如果没有交集，需要多一只飞镖
                ++count;

                // 记录这个不能被上一只飞镖扎爆的气球，后续比大小的时候用
                start = points[i][0];
                end = points[i][1];
            }
        }
        return count;
    }

    /**
     * 用气球尾部升序排序
     *
     * @param points
     * @return count
     */
    public int findMinArrowShots(int[][] points) {
        // 特殊情况不作处理，返回0
        if (points == null || points.length < 1 || points[0].length <= 1) {
            return 0;
        }

        // 对尾部进行升序排序 （尾部升序）
        Arrays.sort(points, (int[] a, int[] b) -> (a[1] > b[1]) ? 1 : -1);
        Arrays.sort(points, (a, b) -> (a[1] < b[1]) ? -1 : 1);

        // 保存尾部
        int end = points[0][1];

        int count = 1;

        for (int[] point : points) {
            // 如果超过尾部的大小，count+1,后续的气球将需要另一飞镖
            if (point[0] > end) {
                // 保存新炸破的气球尾部
                end = point[1];
                ++count;
            }
        }
        return count;
    }
}
