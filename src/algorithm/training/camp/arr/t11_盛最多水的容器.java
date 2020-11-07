package algorithm.training.camp.arr;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @author macfmc
 * @date 2020/11/2-21:37
 */
public class t11_盛最多水的容器 {

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea0(a));

        int[] b = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(b));
    }

    public static int maxArea0(int[] height) {
        int max = 0;
        // 遍历数组
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // 计算每次移动后的面积
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(area, max);
            }
        }
        return max;
    }


    public static int maxArea1(int[] height) {
        // 双指针为与数组两遍
        int l = 0, r = height.length - 1, ans = 0;
        // 边界判断
        while (l < r) {
            // 计算每次移动后的面积
            int area = Math.min(height[l], height[r]) * (r - l);
            // 判断最大值
            ans = Math.max(ans, area);
            // 移动小边，看内部能否有
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
