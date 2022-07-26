//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
// Related Topics 贪心 数学 👍 273 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        Solution solution = new MonotoneIncreasingDigits().new Solution();
        solution.monotoneIncreasingDigits(101);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] strNum= String.valueOf(n).toCharArray();
        int flag=strNum.length;
        for(int i=strNum.length-1;i>-1;i--) {
            if(i-1>-1&&strNum[i-1]>strNum[i]) {
                strNum[i-1]-=1;
                flag=i;
            }
        }
        for(int i=flag;i<strNum.length;i++) {
            strNum[i]='9';
        }
        return Integer.parseInt(new String(strNum));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}