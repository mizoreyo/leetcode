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
        List<Integer> arr=new ArrayList<>();
        dfs(ans,arr,nums,0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans,List<Integer> arr,int[] nums,int i) {
        if(i==nums.length) {
            ans.add(new ArrayList<>(arr));
        } else {
            for(int j=i;j<nums.length;j++) {
                arr.add(nums[j]);
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                dfs(ans,arr,nums,i+1);
                tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                arr.remove(arr.size()-1);
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}