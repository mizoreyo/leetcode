//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2067 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] x=new int[]{0,1};
        solution.permute(x);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> per=new ArrayList<>();
        int[] used=new int[nums.length];
        dfs(ans,per,nums,used);
        return ans;
    }

    public void dfs(List<List<Integer>> ans,List<Integer> per,int[] nums,int[] used) {
        if(per.size()==nums.length) {
            ans.add(new ArrayList<>(per));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]==0) {
                per.add(nums[i]);
                used[i]=1;
                dfs(ans,per,nums,used);
                per.remove(per.size()-1);
                used[i]=0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}