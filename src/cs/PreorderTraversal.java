package cs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author macfmc
 * @date 2020/5/3-22:28
 */
public class PreorderTraversal {
    /**
     * 递归解法
     * 思想： 先序遍历：根左右。先打印根节点，再递归左右子树，需要结合递归的函数调用栈理解
     */
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 输入根节点、list集合
        helper(root, list);
        return list;
    }

    // 利用 helper，加 list 条件
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val); // 保存根节点
        if (root.left != null) {
            helper(root.left, list); // 遍历左子树
        }
        if (root.right != null) {
            helper(root.right, list); // 遍历右子树
        }
    }

    /**
     * 非递归解法-迭代法
     * 思想：迭代法，需要用到一个辅助栈
     */
    public List<Integer> preorderTraversalFunction(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>(); // 存储节点
        List<Integer> list = new ArrayList<>(); // 保存遍历节点的顺序
        TreeNode curr = root; // 根节点
        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                list.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop().right; // 当没有右子树时，只删除最上面节点
        }
        return list;
    }

    /**
     * 首先，定义树的存储结构 TreeNode，Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

}
