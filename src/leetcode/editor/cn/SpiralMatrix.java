//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 1119 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] x=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> y= solution.spiralOrder(x);
        System.out.println(y);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int[][] ds=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[] wall=new int[]{-1,matrix[0].length,matrix.length,-1};
        int d=0;
        int n=0;
        int m=0;
        while (true) {
            ans.add(matrix[n][m]);
            //如果要撞墙，就转向
            if(!((m+ds[d][1]<wall[1]&&m+ds[d][1]>wall[3])&&(n+ds[d][0]<wall[2]&&n+ds[d][0]>wall[0]))) {
                d=(d+1)%4;
                //如果还要撞墙，就到了尽头
                if(!((m+ds[d][1]<wall[1]&&m+ds[d][1]>wall[3])&&(n+ds[d][0]<wall[2]&&n+ds[d][0]>wall[0]))) {
                    break;
                }
                if(d==0) {
                    wall[3]++;
                } else if(d==1) {
                    wall[0]++;
                } else if(d==2) {
                    wall[1]--;
                } else {
                    wall[2]--;
                }
            }
            n+=ds[d][0];
            m+=ds[d][1];
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}