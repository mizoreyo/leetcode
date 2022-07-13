//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// Related Topics 位运算 数组 哈希表 回溯 👍 472 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new IncreasingSubsequences().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashMap<Integer,Boolean> used=new HashMap<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> child=new ArrayList<>();
        backtracking(nums,0,ans,child);
        return ans;
    }

    public void backtracking(int[] nums,int start,List<List<Integer>> ans,List<Integer> child) {
        if(start== nums.length) {
            return;
        }
        for(int i=start;i< nums.length;i++) {
            boolean beforeSame=false;
            for(int j=start;j<i;j++) {
                if(nums[j]==nums[i]) {
                    beforeSame = true;
                    break;
                }
            }
            if (beforeSame)
                continue;
            if(!child.isEmpty()&&child.get(child.size()-1)>nums[i]) {
                continue;
            }
            child.add(nums[i]);
            if(child.size()>=2)
                ans.add(new ArrayList<>(child));
            backtracking(nums,i+1,ans,child);
            child.remove(child.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}