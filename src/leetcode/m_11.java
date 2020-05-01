package leetcode;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @author macfmc
 * @date 2020/5/1-15:11
 */
public class m_11 {

    public static void main(String[] args) {

    }

    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1, ans = 0; // 双指针为与数组两遍
        while (l < r) { // 边界判断
            int area = Math.min(height[l], height[r]) * (r - l); // 计算每次移动后的面积
            ans = Math.max(ans, area); // 判断最大值
            if (height[l] < height[r]) {// 移动小边，看内部能否有
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }


}
