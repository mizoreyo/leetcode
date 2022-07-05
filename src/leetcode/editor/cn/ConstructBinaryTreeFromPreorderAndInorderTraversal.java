//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1651 👎 0

package leetcode.editor.cn;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode root=new TreeNode();
            traversal(inorder,preorder,0,inorder.length,0,preorder.length,root,true);
            return root.left;
        }

        public void traversal(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd, TreeNode father, boolean isLeft) {
            if(preStart==preEnd)
                return;
            int preFirst=preorder[preStart];
            TreeNode node;
            if(isLeft) {
                father.left=new TreeNode(preFirst);
                node=father.left;
            } else {
                father.right=new TreeNode(preFirst);
                node=father.right;
            }
            if(preEnd-preStart==1)
                return;
            int index=inStart;
            for(int i=inStart;i<inEnd;i++) {
                if(preFirst==inorder[i]) {
                    index=i;
                    break;
                }
            }
            traversal(inorder,preorder,inStart,index,preStart+1,preStart+1+index-inStart,node,true);
            traversal(inorder,preorder,index+1,inEnd,preStart+1+index-inStart,preEnd,node,false);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}