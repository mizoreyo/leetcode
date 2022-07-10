//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 1045 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> com=new ArrayList<>();
        backtracking(n,k,1,ans,com);
        return ans;
    }

    public void backtracking(int n,int k,int start,List<List<Integer>> ans,List<Integer> com) {
        if(k==0) {
            ans.add(new ArrayList<>(com));
            return;
        }
        for(int i=start;i<n+1;i++) {
            if(n-i+1<k) {
                return;
            }
            com.add(i);
            backtracking(n,k-1,i+1,ans,com);
            com.remove(com.size()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}