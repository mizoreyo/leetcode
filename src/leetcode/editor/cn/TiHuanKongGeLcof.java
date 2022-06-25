//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 303 👎 0

package leetcode.editor.cn;
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        int count=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==' ') {
                count++;
            }
        }
        char[] newStr=new char[s.length()+count*2];
        int j=newStr.length-1;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i)==' ') {
                newStr[j]='0';
                newStr[j-1]='2';
                newStr[j-2]='%';
                j-=3;
            } else {
                newStr[j]=s.charAt(i);
                j--;
            }
        }

        return new String(newStr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}