//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 588 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans=levelOrder(root);
            Collections.reverse(ans);
            return ans;
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans=new ArrayList<>();
            if(root==null) {
                return ans;
            }
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size=queue.size();
                List<Integer> layer=new ArrayList<>();
                for(int i=0;i<size;i++) {
                    TreeNode head=queue.remove();
                    layer.add(head.val);
                    if(head.left!=null)
                        queue.add(head.left);
                    if(head.right!=null)
                        queue.add(head.right);
                }
                ans.add(layer);
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}