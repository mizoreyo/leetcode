//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1525 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] x=new int[][]{{2,6},{1,3},{8,10},{15,18}};
        solution.merge(x);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==0) {
            return new int[0][2];
        }
        Arrays.sort(intervals,(o1, o2) ->o1[0]-o2[0]);
        List<int[]> ans=new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0]>ans.get(ans.size()-1)[1]) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size()-1)[1]=Integer.max(intervals[i][1],ans.get(ans.size()-1)[1]) ;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}