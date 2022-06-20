//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵ 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 10⁵ 
// 
// Related Topics 数组 👍 600 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
        int[][] x=new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] y=new int[]{4,8};
        System.out.println(Arrays.deepToString(solution.insert(x,y)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) {
            return new int[][]{newInterval};
        }
        List<int[]> ans=new ArrayList<>();
        int start=0;
        int end=0;
        int times=1;
        int btimes=1;
        for(int i=0;i<intervals.length;i++) {
            if(newInterval[0]>intervals[i][1]) {
                ans.add(intervals[i]);
                if(i== intervals.length-1) {
                    if(btimes>0) {
                        start=newInterval[0];
                        btimes--;
                    }
                }
            } else if(newInterval[0]>=intervals[i][0]) {
                if(btimes>0) {
                    start=intervals[i][0];
                    btimes--;
                }
            } else if(newInterval[0]<intervals[i][0]) {
                if(btimes>0) {
                    start=newInterval[0];
                    btimes--;
                }
            }
            if(newInterval[1]<intervals[i][0]) {
                if(times>0) {
                    end=newInterval[1];
                    ans.add(new int[]{start,end});
                    times--;
                }
                ans.add(intervals[i]);
            } else if(newInterval[1]<=intervals[i][1]){
                if(times>0) {
                    end=intervals[i][1];
                    ans.add(new int[]{start,end});
                    times--;
                }
            } else if(i== intervals.length-1) {
                if(times>0) {
                    end=newInterval[1];
                    ans.add(new int[]{start,end});
                    times--;
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}