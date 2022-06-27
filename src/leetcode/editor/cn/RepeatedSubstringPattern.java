//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 722 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        boolean is= solution.repeatedSubstringPattern("aa");
        System.out.println(is);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()==0) {
            return false;
        }
        int[] next=getNext(s);
        System.out.println(Arrays.toString(next));
        int len=s.length();
        if (next[len] != 0 && len % (len - (next[len])) == 0) {
            return true;
        }
        return false;
    }

    public int[] getNext(String needle) {
        int j=0;
        int k=-1;
        int[] next=new int[needle.length()+1];
        next[j]=k;
        while (j<needle.length()) {
            if(k==-1||needle.charAt(j)==needle.charAt(k)) {
                j++;
                k++;
                //if(needle.charAt(j)!=needle.charAt(k)) {
                    next[j]=k;
                //} else {
                //    next[j]=next[k];
                //}

            } else {
                k=next[k];
            }
        }
        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}