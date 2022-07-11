//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1191 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println(solution.partition("efe"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> cs=new ArrayList<>();
        backtracking(s,0,ans,cs);
        return ans;
    }

    public void backtracking(String s,int startIndex,List<List<String>> ans,List<String> cs) {
        if(startIndex==s.length()) {
            ans.add(new ArrayList<>(cs));
            return;
        }
        for(int i=startIndex;i<s.length();i++) {
            if(!isPalindromic(s,startIndex,i+1))
                continue;
            String part=s.substring(startIndex,i+1);
            cs.add(part);
            backtracking(s,i+1,ans,cs);
            cs.remove(cs.size()-1);
        }
    }

    public boolean isPalindromic(String s,int start,int end) {
        for(int i=start;i<(end-start)/2+start;i++) {
            if(s.charAt(i)!=s.charAt(start+end-1-i))
                return false;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}