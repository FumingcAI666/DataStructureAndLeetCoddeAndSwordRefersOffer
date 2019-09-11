package sword.refers.offer.demo;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author macfmc
 * @date 2019/9/9-23:55
 */
public class Pro22 {
    public static void main(String[] args) {

    }

    /**
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return ju(sequence, 0, sequence.length - 1);

    }

    /**
     * @param a
     * @param star
     * @param root
     * @return
     */
    public boolean ju(int[] a, int star, int root) {
        if (star >= root) {
            return true;
        }
        int i = root;
        //从后面开始找
        while (i > star && a[i - 1] > a[root]) {
            //找到比根小的坐标
            i--;
        }
        //从前面开始找 star到i-1应该比根小
        for (int j = star; j < i - 1; j++) {
            if (a[j] > a[root]) {
                return false;
            }
        }
        return ju(a, star, i - 1) && ju(a, i, root - 1);
    }
}
