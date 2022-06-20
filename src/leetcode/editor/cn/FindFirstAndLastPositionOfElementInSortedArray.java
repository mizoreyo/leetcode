//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1719 👎 0

package leetcode.editor.cn;
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        solution.searchRange(new int[]{5,7,7,8,8,10},6);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0||target<nums[0]||target>nums[nums.length-1]) {
            return new int[]{-1,-1};
        }
        int left=getLeft(nums,target);
        int right=getRight(nums,target);
        return new int[]{left,right};
    }

    public int getLeft(int[] nums,int target) {
        int left=0;
        int right=nums.length-1;
        int m;
        while (left<=right) {
            m=(left+right)/2;
            if(nums[m]==target&&(m-1==-1||nums[m-1]!=target)) {
                return m;
            } else if(target<=nums[m]) {
                right=m-1;
            } else {
                left=m+1;
            }
        }
        return -1;
    }

    public int getRight(int[] nums,int target) {
        int left=0;
        int right=nums.length-1;
        int m;
        while (left<=right) {
            m=(left+right)/2;
            if(nums[m]==target&&(m+1== nums.length||nums[m+1]!=target)) {
                return m;
            } else if(target<nums[m]) {
                right=m-1;
            } else {
                left=m+1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}