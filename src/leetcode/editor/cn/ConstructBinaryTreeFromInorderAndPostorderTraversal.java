//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 780 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            TreeNode root=new TreeNode();
            traversal(inorder,postorder,0,inorder.length,0,postorder.length,root,true);
            return root.left;
        }

        public void traversal(int[] inorder,int[] postorder,int inStart,int inEnd,int postStart,int postEnd,TreeNode father,boolean isLeft) {
            //后序序列长度为0
            if(postStart==postEnd)
                return;
            //后序序列最后一个
            int postLast=postorder[postEnd-1];
            TreeNode node;
            if(isLeft) {
                father.left=new TreeNode(postLast);
                node=father.left;
            } else {
                father.right=new TreeNode(postLast);
                node=father.right;
            }
            //后序序列长度为1，没必要再对两个长度为0的序列进行处理
            if(postEnd-postStart==1)
                return;
            //在中序序列中查找后序序列的最后一个
            int index=inStart;
            for(int i=inStart;i<inEnd;i++) {
                if(postLast==inorder[i]) {
                    index=i;
                }
            }
            traversal(inorder,postorder,inStart,index,postStart,postStart+index-inStart,node,true);
            traversal(inorder,postorder,index+1,inEnd,postStart+index-inStart,postEnd-1,node,false);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}