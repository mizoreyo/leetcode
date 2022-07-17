//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
//
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
// Related Topics 深度优先搜索 图 欧拉回路 👍 595 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<String,Map<String,Integer>> map;
    private String begin;

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans=new ArrayList<>();
        map=new HashMap<>();
        for(List<String> ticket:tickets) {
            Map<String,Integer> aMap=map.getOrDefault(ticket.get(0),new TreeMap<>());
            aMap.put(ticket.get(1),aMap.getOrDefault(ticket.get(1),0)+1);
            map.put(ticket.get(0),aMap);
        }
        ans.add("JFK");
        begin="JFK";
        backtracking(tickets.size(), ans);
        return ans;
    }

    public boolean backtracking(int ticketNum,List<String> ans) {
        if(ans.size()==ticketNum+1) {
            return true;
        }
        if(!map.containsKey(begin)) {
            return false;
        }
        for(Map.Entry<String,Integer> entry:map.get(begin).entrySet()) {
            String dest=entry.getKey();
            Integer ticketRemain=entry.getValue();
            if(ticketRemain>0) {
                ans.add(dest);
                map.get(begin).put(dest,ticketRemain-1);
                String temp=begin;
                begin=dest;
                boolean success = backtracking(ticketNum,ans);
                if(success) {
                    return true;
                }
                ans.remove(ans.size()-1);
                map.get(temp).put(dest,ticketRemain);
                begin=temp;
            }
        }
        return false;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}