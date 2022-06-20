//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 👍 950 👎 0

package leetcode.editor.cn;
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("9133","0"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1=num1.length();
        int n2=num2.length();
        String ans="0";
        for(int i=0;i<n2;i++) {
            int y=num2.charAt(n2-i-1)-'0';
            StringBuffer sb=new StringBuffer();
            int forward=0;
            for(int j=0;j<n1;j++) {
                int product= (num1.charAt(n1-j-1)-'0')*y+forward;
                if(product>9) {
                    forward=product/10;
                    product%=10;
                } else  {
                    forward=0;
                }
                sb.append(product);
            }
            if(forward>0) {
                sb.append(forward);
            }
            sb.reverse();
            for(int j=0;j<i;j++) {
                sb.append(0);
            }
            ans=addStrings(ans,sb.toString());
        }
        return ans;
    }

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