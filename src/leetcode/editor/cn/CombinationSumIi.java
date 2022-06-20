//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 987 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] x=new int[]{2,5,2,1,2};
        solution.combinationSum2(x,5);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<int[]> freq=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> combine=new ArrayList<>();
        //初始化freq
        Arrays.sort(candidates);
        int j=-1;
        int last=99;//一个不可能出现在candidates中的数
        for(int i=0;i<candidates.length;i++) {
            if(candidates[i]!=last) {
                int[] a=new int[2];
                a[0]=candidates[i];
                a[1]=1;
                freq.add(a);
                last=candidates[i];
                j++;
            } else {
                freq.get(j)[1]++;
            }
        }
        dfs(freq,target,0,ans,combine);
        return ans;
    }

        public void dfs(List<int[]> freq,int target,int idx,List<List<Integer>> ans,List<Integer> combine) {
            if(target==0) {
                ans.add(new ArrayList<>(combine));
                return;
            } else if(idx==freq.size()) {
                return;
            }
            int most=Math.min(target/freq.get(idx)[0],freq.get(idx)[1]);
            for(int i=1;i<=most;i++) {
                combine.add(freq.get(idx)[0]);
                dfs(freq,target-i*freq.get(idx)[0],idx+1,ans,combine);
            }
            for(int i=1;i<=most;i++) {
                combine.remove(combine.size()-1);
            }
            dfs(freq,target,idx+1,ans,combine);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}