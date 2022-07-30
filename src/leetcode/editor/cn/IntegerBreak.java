//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics 数学 动态规划 👍 878 👎 0

package leetcode.editor.cn;
public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        //dp[i]代表拆分i所得到的最大乘积
        int[] dp=new int[n+1];
        dp[2]=1;
        for(int i=3;i<n+1;i++) {
            //因为不存在dp[1]，并且当j==1和j==i-1时，j*(i-j)的值是一样的，所以j可以只到i-2
            for(int j=1;j<i-1;j++) {
                dp[i]=Math.max(Math.max(j*(i-j),j*dp[i-j]),dp[i]);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}