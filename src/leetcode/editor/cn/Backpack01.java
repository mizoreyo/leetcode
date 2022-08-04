package leetcode.editor.cn;

import java.util.Arrays;

public class Backpack01 {
    public static void main(String[] args) {
        Solution solution = new Backpack01().new Solution();
        System.out.println(solution.backpack2(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4));
    }
    class Solution {
        public int backpack(int[] weight,int[] value,int packWeight) {
            int m=weight.length;
            int n=packWeight+1;
            int[][] dp=new int[m][packWeight+1];
            //初始化
            for(int j=weight[0];j<n;j++) {
                dp[0][j]=value[0];
            }
            for(int i=1;i<m;i++) {
                for(int j=1;j<n;j++) {
                    if(j<weight[i]) //物品重量超过背包容量
                        dp[i][j]=dp[i-1][j];
                    else
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
            return dp[m-1][n-1];
        }

        public int backpack2(int[] weight,int[] value,int packWeight) {
            int[] dp=new int[packWeight+1];
            for(int i=0;i<weight.length;i++) {
                for(int j=packWeight;j>=0;j--) {
                    if(j>=weight[i])
                        dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
            return dp[packWeight];
        }
    }

}
