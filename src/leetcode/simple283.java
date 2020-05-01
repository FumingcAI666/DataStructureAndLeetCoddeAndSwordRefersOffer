package leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author YXH
 * @date 2020/4/29 - 20:13
 */
public class simple283 {
    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 3, 12};
        int[] test2 = {0, 1, 0, 3, 12, 0};
        int[] test3 = {5, 0, 1, 0, 3, 12};
        print(moveZeroes(test1));
        System.out.println();
        print(moveZeroes(test2));
        System.out.println();
        print(moveZeroes(test3));
    }

    /**
     * 我们创建两个指针i和j，第一次遍历的时候指针j用来记录当前有多少非0元素。
     * 即遍历的时候每遇到一个非0元素就将其往数组左边挪，第一次遍历完后，j指针的下标就指向了最后一个非0元素下标。
     * 第二次遍历的时候，起始位置就从j开始到结束，将剩下的这段区域内的元素全部置为0。
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     *
     * @param nums
     */
    public static int[] moveZeroes(int[] nums) {
        if (nums == null) {
            return null;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
        return nums;
    }

    private static void print(int[] nums) {
        for (int i : nums
        ) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
