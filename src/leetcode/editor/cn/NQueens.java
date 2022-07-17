//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1415 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> solution=new ArrayList<>();
        backtracking(ans,solution,0,n);
        return ans;
    }

    public void backtracking(List<List<String>> ans,List<String> solution,int depth,int n) {
        if(depth==n) {
            ans.add(new ArrayList<>(solution));
            return;
        }
        for(int i=0;i<n;i++) {
            if(isValid(solution,depth,i)) {
                StringBuilder layer= new StringBuilder();
                for(int j=0;j<i;j++) {
                    layer.append(".");
                }
                layer.append("Q");
                for(int j=i+1;j<n;j++) {
                    layer.append(".");
                }
                solution.add(layer.toString());
                backtracking(ans,solution,depth+1,n);
                solution.remove(solution.size()-1);
            }
        }
    }

    public boolean isValid(List<String> solution,int depth,int index) {
        for(int d=0;d<solution.size();d++) {
            String layer=solution.get(d);
            int i=layer.indexOf("Q");
            if(i==index) {
                return false;
            }
            if(d-depth==i-index||d-depth==index-i) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}