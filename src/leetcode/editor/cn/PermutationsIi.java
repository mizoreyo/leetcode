//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1094 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if(i-1>=0&&nums[i]==nums[i-1]&&used[i-1]==0)
                continue;
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