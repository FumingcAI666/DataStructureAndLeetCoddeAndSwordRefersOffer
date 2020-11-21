package algorithm.training.camp.tree;

/**
 * @author macfmc
 * @date 2020/11/21-22:41
 */
public class t226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        // 如果是空，证明没有左/右子树
        if (root == null) {
            return root;
        }

        // 将左子树保存
        TreeNode left = invertTree(root.left);
        // 将右子树保存
        TreeNode right = invertTree(root.right);

        // 将左右字数交换
        root.left = right;
        root.right = left;

        // 返回当前节点
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

}
