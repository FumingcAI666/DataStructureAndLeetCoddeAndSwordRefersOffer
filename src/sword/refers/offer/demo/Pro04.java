package sword.refers.offer.demo;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序
 * 遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author macfmc
 * @date 2019/8/26-17:49
 */
public class Pro04 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(reConstructBinaryTree(pre, in).toString());
    }

    public static TreeNode04 reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode04 root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    /**
     * 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
     */
    private static TreeNode04 reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode04 root = new TreeNode04(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}

/**
 * Definition for binary tree
 */
class TreeNode04 {
    int val;
    TreeNode04 left;
    TreeNode04 right;

    TreeNode04(int x) { val = x; }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TreeNode04{");
        sb.append("val=").append(val);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}