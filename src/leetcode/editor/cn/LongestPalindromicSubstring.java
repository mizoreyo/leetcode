//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5031 👎 0

package leetcode.editor.cn;
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int length=s.length();
        //若为单个字符，则必定为回文串
        if(length<2) {
            return s;
        }
        //存放子串是否为回文
        boolean[][] isPalin=new boolean[length][length];
        int maxLength=1;
        int begin=0;
        //初始化，单字符必定为回文
        for(int i=0;i<length;i++) {
            isPalin[i][i]=true;
        }
        //转化为数组是因为charAt耗费性能
        char[] sArray=s.toCharArray();
        for(int i=1;i<length;i++) {
            for(int j=0;j<i;j++) {
                if(sArray[i]!=sArray[j]) {
                    isPalin[j][i]=false;
                } else if(i-j+1>2) {
                    isPalin[j][i]=isPalin[j+1][i-1];
                } else {
                    isPalin[j][i]=true;
                }
                if(isPalin[j][i] &&i-j+1>maxLength) {
                    maxLength=i-j+1;
                    begin=j;
                }
            }
        }
        return s.substring(begin,begin+maxLength);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}