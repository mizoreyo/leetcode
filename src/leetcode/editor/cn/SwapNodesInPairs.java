//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1404 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start=head;

        ListNode node1=start;
        ListNode node2=null;
        if(node1!=null) {
            node2=node1.next;
        }

        ListNode nextStart=null;
        if(node2!=null) {
            nextStart=node2.next;
            start=node2;
        }

        while (node2!=null) {
            node2.next=node1;
            if(nextStart!=null&&nextStart.next!=null) {
                node1.next=nextStart.next;
            } else if(nextStart!=null&&nextStart.next==null){
                node1.next=nextStart;
            }
             else {
                node1.next=null;
            }
            node1=nextStart;
            if(node1!=null) {
                node2=node1.next;
            } else {
                node2=null;
            }
            if(node2!=null) {
                nextStart=node2.next;
            }
        }

        return start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}