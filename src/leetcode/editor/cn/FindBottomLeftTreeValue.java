//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 351 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
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
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            TreeNode last=null;
            while (!queue.isEmpty()) {
                int size=queue.size();
                for(int i=0;i<size;i++) {
                    last=queue.remove();
                    if(last.right!=null)
                        queue.add(last.right);
                    if(last.left!=null)
                        queue.add(last.left);
                }
            }
            return last.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}