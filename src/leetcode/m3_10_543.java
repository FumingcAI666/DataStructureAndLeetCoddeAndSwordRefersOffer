package leetcode;

/**
 * @author macfmc
 * @date 2020/3/10-17:05
 */
public class m3_10_543 {
    /**
     给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

     示例 :
     给定二叉树

      1
     / \
     2   3
   / \
  4   5
     返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

     注意：两结点之间的路径长度是以它们之间边的数目表示。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int max = 0;
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        travel(root);
        return max;
    }

    // 递归访问每个节点，后序遍历从底层往上计算，计算每个节点左子树和右子树的高度和，最大值即为最大路径。
    public int travel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = travel(root.left);    // 求左子树高度
        int rightH = travel(root.right);  // 求右子树高度
        if (leftH + rightH > max) {       // 如果左右子树的高度和，判断是否大于当前max
            max = leftH + rightH;
        }
        return (leftH > rightH ? leftH : rightH) + 1;  // 该root节点的高度为左右子树高度的较大值+1
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0; // 访问到空节点了，返回0
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
