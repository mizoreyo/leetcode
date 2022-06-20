//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1911 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("234");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) {
            return new ArrayList<String>();
        }
        Map<Character,String> numLetterMap=new HashMap<>();
        numLetterMap.put('2',"abc");
        numLetterMap.put('3',"def");
        numLetterMap.put('4',"ghi");
        numLetterMap.put('5',"jkl");
        numLetterMap.put('6',"mno");
        numLetterMap.put('7',"pqrs");
        numLetterMap.put('8',"tuv");
        numLetterMap.put('9',"wxyz");
        List<String> result=new ArrayList<>();
        int index=0;
        backtrack(numLetterMap,digits,new StringBuilder(),result,index);
        return result;
    }

    public void backtrack(Map<Character,String> numLetterMap,String digits,StringBuilder combination,List<String> result,int index) {
        if(index==digits.length()) {
            result.add(combination.toString());
        } else {
            char digit=digits.charAt(index);
            String letters=numLetterMap.get(digit);
            for(int i=0;i<letters.length();i++) {
                combination.append(letters.charAt(i));
                backtrack(numLetterMap,digits,combination,result,index+1);
                combination.deleteCharAt(index);
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}