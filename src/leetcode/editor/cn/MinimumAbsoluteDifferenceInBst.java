//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 354 👎 0

package leetcode.editor.cn;
public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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
        public int getMinimumDifference(TreeNode root) {
             return traversal(root);
        }

        public int traversal(TreeNode node) {
            if(node==null)
                return Integer.MAX_VALUE;
            if(node.left==null&&node.right==null)
                return Integer.MAX_VALUE;
            int leftDiff=Integer.MAX_VALUE;
            int rightDiff=Integer.MAX_VALUE;
            if(node.left!=null) {
                TreeNode node1=node.left;
                while (node1.right!=null) {
                    node1=node1.right;
                }
                leftDiff=Math.abs(node.val-node1.val);
            }
            if(node.right!=null) {
                TreeNode node2=node.right;
                while (node2.left!=null) {
                    node2=node2.left;
                }
                rightDiff=Math.abs(node.val-node2.val);
            }
            int leftNextDiff=traversal(node.left);
            int rightNextDiff=traversal(node.right);
            return Math.min(Math.min(leftDiff,rightDiff),Math.min(leftNextDiff,rightNextDiff));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}