//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1469 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        int r= solution.strStr("aaabaaaab","aaaab");
        System.out.println(r);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) {
            return -1;
        }
        if(needle.length()==0) {
            return 0;
        }
        int[] next=getNext(needle);
        //System.out.println(Arrays.toString(next));
        int i=0;
        int j=0;
        while (i<haystack.length()) {
            if(j==-1||haystack.charAt(i)==needle.charAt(j)) {
                i++;
                j++;
                if(j==needle.length()) {
                    return i-j;
                }
            } else {
                j=next[j];
            }
        }
        return -1;
    }

    public int[] getNext(String needle) {
        int j=0;
        int k=-1;
        int[] next=new int[needle.length()];
        next[j]=k;
        while (j<needle.length()-1) {
            if(k==-1||needle.charAt(j)==needle.charAt(k)) {
                j++;
                k++;
                if(needle.charAt(j)!=needle.charAt(k)) {
                    next[j]=k;
                } else {
                    next[j]=next[k];
                }

            } else {
                k=next[k];
            }
        }
        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}