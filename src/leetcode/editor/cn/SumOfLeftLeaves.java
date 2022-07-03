//给定二叉树的根节点 root ，返回所有左叶子之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 469 👎 0

package leetcode.editor.cn;
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
        solution.sumOfLeftLeaves(new SumOfLeftLeaves().new TreeNode());
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            return traversal(root);
        }

        public int traversal(TreeNode node) {
            if(node==null)
                return 0;
            int a=0;
            if(node.left!=null&&node.left.left==null&&node.left.right==null) {
                a=node.left.val;
            } else {
                a=traversal(node.left);
            }
            int b=traversal(node.right);
            return a+b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}