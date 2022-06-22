//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。 
//
// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果： 
//
// 
// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。 
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到
//下一棵树，并继续采摘。 
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。 
// 
//
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。
// 
//
// 示例 2： 
//
// 
//输入：fruits = [0,1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
// 
//
// 示例 3： 
//
// 
//输入：fruits = [1,2,3,2,2]
//输出：4
//解释：可以采摘 [2,3,2,2] 这四棵树。
//如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
// 
//
// 示例 4： 
//
// 
//输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：可以采摘 [1,2,1,1,2] 这五棵树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 233 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int totalFruit(int[] fruits) {
            //定义两种篮子   开始的时候左边的篮子是从0开始，然后右边的篮子是一直累加
            int cnt =0;
            int left = 0;
            int right = 0;

            int fruitA = fruits[left];
            int fruitB = fruits[right];

            while (right<fruits.length){
                //说明新遍历的树是跟第一个篮子相同或者是跟第二个篮子相同，这个时候说明是可以添加，能够一直保持着两种
                if(fruits[right] == fruitA || fruits[right] == fruitB){
                    cnt = Math.max(cnt,right-left+1);
                    right++;
                }else{
                    //已经有两种了，遇到第三种，需要最左边的篮子移动到之前的第二个类别，
                    //空出一个篮子给下一个类别，往后就进行循环
                    left = right -1;
                    fruitA = fruits[left];  //这一步主要是为了更新第一个篮子
                    //下一步是更新第一个篮子的数量
                    while (left>0 && fruits[left-1] == fruitA){
                        left--;
                    }
                    //最终是更新第二个篮子，位置是同一类别中的最后一个位置
                    fruitB = fruits[right];
                    cnt = Math.max(cnt,right-left+1);
                }
            }
            return cnt;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}