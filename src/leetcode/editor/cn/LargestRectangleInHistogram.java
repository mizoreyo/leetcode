//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 2068 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        //数组扩容，在最前和最后都加0
        int[] hArray=new int[heights.length+2];
        hArray[0]=hArray[hArray.length-1]=0;
        for(int i=0;i< heights.length;i++) {
            hArray[i+1]=heights[i];
        }
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(0);
        for(int i=1;i<hArray.length;i++) {
            while (hArray[i]<hArray[stack.peek()]) {
                int mid=stack.pop();
                int leftIndex= stack.peek();
                maxArea=Math.max((i-leftIndex-1)*hArray[mid],maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}