package leetcode.offer;


/**
 * @author macfmc
 * @date 2020/7/11-11:33
 */
public class 面试题27_二叉树的镜像 {
    /**
     * 每一个节点都交换左右子树，从根节点开始交换
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if (root == null) {
            return null;
        }

        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        mirrorTree(root.left);
        //递归交换当前节点的 右子树
        mirrorTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
