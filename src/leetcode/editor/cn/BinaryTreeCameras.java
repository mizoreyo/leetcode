//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 443 👎 0

package leetcode.editor.cn;
public class BinaryTreeCameras {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeCameras().new Solution();
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
        private int cameraNum=0;
        public int minCameraCover(TreeNode root) {
            int rootStatus=traversal(root);
            if(rootStatus==0)
                cameraNum++;
            return cameraNum;
        }

        //0：未覆盖
        //1：有摄像头
        //2：有覆盖
        public int traversal(TreeNode node) {
            if(node==null)
                return 2;
            int leftStatus = traversal(node.left);
            int rightStatus = traversal(node.right);
            //如果左右两节点为有覆盖，则此节点为未覆盖
            if(leftStatus==2&&rightStatus==2)
                return 0;
            //如果两节点中至少一个未覆盖，则此节点应该为有摄像头
            if(leftStatus==0||rightStatus==0) {
                cameraNum++;
                return 1;
            }
            //如果两节点至少有一个摄像头，则此节点为有覆盖
            //if(leftStatus==2||rightStatus==2)
            //    return 2;
            return 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}