//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 737 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int[][] ds=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[] wall=new int[]{-1,n,n,-1};
        int d=0;
        int x=0;
        int y=0;
        int i=1;
        while (true) {
            ans[x][y]=i;
            i++;
            //如果要撞墙，就转向
            if(!((y+ds[d][1]<wall[1]&&y+ds[d][1]>wall[3])&&(x+ds[d][0]<wall[2]&&x+ds[d][0]>wall[0]))) {
                d=(d+1)%4;
                //如果还要撞墙，就到了尽头
                if(!((y+ds[d][1]<wall[1]&&y+ds[d][1]>wall[3])&&(x+ds[d][0]<wall[2]&&x+ds[d][0]>wall[0]))) {
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
            x+=ds[d][0];
            y+=ds[d][1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}