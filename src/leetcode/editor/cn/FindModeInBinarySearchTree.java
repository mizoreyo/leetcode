//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 478 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
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

        private TreeNode pre;
        int maxCount;
        int count;

        public int[] findMode(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
            traversal(root,ans);
            int[] result=new int[ans.size()];
            for(int i=0;i<result.length;i++) {
                result[i]=ans.get(i);
            }
            return result;
        }

        public void traversal(TreeNode cur,List<Integer> ans) {
            if(cur==null)
                return;
            traversal(cur.left,ans);
            if(pre==null) {
                ans.add(cur.val);
                count=1;
                maxCount=1;
            } else {
                if(cur.val== pre.val) {
                    count++;
                } else {
                    count=1;
                }
                if(count==maxCount) {
                    ans.add(cur.val);
                } else if(count>maxCount) {
                    ans.clear();
                    ans.add(cur.val);
                    maxCount=count;
                }
            }
            pre=cur;
            traversal(cur.right,ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}