//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 761 👎 0

package leetcode.editor.cn;
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            return traversal(root,subRoot);
        }

        public boolean traversal(TreeNode node, TreeNode subRoot) {
            if(node==null) {
                return false;
            }
            if(node.val==subRoot.val&&compare(node,subRoot)) {
                return true;
            } else {
                return traversal(node.left,subRoot)||traversal(node.right,subRoot);
            }
        }

        public boolean compare(TreeNode left, TreeNode right) {
            if(left==null&&right!=null)
                return false;
            else if(left!=null&&right==null)
                return false;
            else if(left==null&&right==null)
                return true;
            else if(left.val!=right.val)
                return false;
            boolean outside=compare(left.left,right.left);
            boolean inside=compare(left.right,right.right);
            return outside&&inside;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}