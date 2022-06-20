//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 572 👎 0

package leetcode.editor.cn;
public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        System.out.println(solution.addStrings("923","3"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer sb=new StringBuffer();
        int n1=num1.length();
        int n2=num2.length();
        int n=Math.max(n1,n2);
        int forward=0;
        for(int i=0;i<n;i++) {
            int sum=0;
            if(n1-i-1>=0&&n2-i-1>=0) {
                sum=num1.charAt(n1-i-1)+num2.charAt(n2-i-1)-96+forward;
            } else if(n1-i-1<0&&n2-i-1>=0) {
                sum=num2.charAt(n2-i-1)-48+forward;
            } else if(n1-i-1>=0&&n2-i-1<0) {
                sum=num1.charAt(n1-i-1)-48+forward;
            }
            if(sum>9) {
                sum-=10;
                forward=1;
            } else {
                forward=0;
            }
            sb.append(sum);
        }
        if(forward==1) {
            sb.append(1);
        }
        sb.reverse();
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}