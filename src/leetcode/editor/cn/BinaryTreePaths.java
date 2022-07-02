//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 773 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans=new ArrayList<>();
            StringBuffer sb=new StringBuffer();
            traversal(ans,sb,root);
            return ans;
        }

        public void traversal(List<String> ans,StringBuffer sb,TreeNode node) {
            if(node==null) {
                return;
            }
            sb.append(node.val);
            boolean isLast=false;
            if(node.left==null&&node.right==null) {
                ans.add(sb.toString());
                isLast=true;
            } else {
                sb.append("->");
            }
            traversal(ans,sb,node.left);
            traversal(ans,sb,node.right);
            if(isLast)
                sb.delete(sb.length()-(String.valueOf(node.val).length()),sb.length());
            else
                sb.delete(sb.length()-(String.valueOf(node.val).length())-2,sb.length());
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}