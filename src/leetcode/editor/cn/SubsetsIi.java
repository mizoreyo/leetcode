//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 874 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        ans.add(new ArrayList<>(subset));
        Arrays.sort(nums);
        backtracking(nums,0,ans,subset);
        return ans;
    }

    public void backtracking(int[] nums,int start,List<List<Integer>> ans,List<Integer> subset) {
        if(start==nums.length)
            return;
        for(int i=start;i<nums.length;i++) {
            if(i-1>=start&&nums[i]==nums[i-1])
                continue;
            subset.add(nums[i]);
            ans.add(new ArrayList<>(subset));
            backtracking(nums,i+1,ans,subset);
            subset.remove(subset.size()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}