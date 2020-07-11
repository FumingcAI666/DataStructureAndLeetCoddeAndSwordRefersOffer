package leetcode.offer;

/**
 * @author macfmc
 * @date 2020/7/11-12:44
 */
public class 面试题28_对称的二叉树 {
    /**
     * 判断跟节点的左右子孩子是否一致，左右子孩子继续判断，左子节点的左孩子，右子节点的右孩子，在继续判断左子节点的右孩子-右子节点的左孩子
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null)
            return true;
        if (L == null || R == null || L.val != R.val)
            return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


}
