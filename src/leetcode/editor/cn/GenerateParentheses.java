//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2663 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        List<List<String>> total=new ArrayList<>();
        List<String> child0=new ArrayList<>();
        List<String> child1=new ArrayList<>();
        child0.add(null);
        child1.add("()");
        total.add(child0);
        total.add(child1);
        for(int i=2;i<=n;i++) {
            List<String> l=new ArrayList<>();
            for(int j=0;j<i;j++) {
                List<String> l1=total.get(j);
                List<String> l2=total.get(i-1-j);
                for(String s1: l1) {
                    for(String s2: l2) {
                        if(s1==null) {
                            s1="";
                        }
                        if(s2==null) {
                            s2="";
                        }
                        l.add("("+s1+")"+s2);
                    }
                }
            }
            total.add(l);
        }
        return total.get(n);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}