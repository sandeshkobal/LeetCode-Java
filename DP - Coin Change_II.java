/*
https://leetcode.com/problems/coin-change-2/
You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount. 
You may assume that you have infinite number of each kind of coin.
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
*/
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || amount<0)
            return 0;
        int []dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i=coin; i<=amount; i++){
                dp[i] = dp[i] + dp[i-coin];
            }    
        }
        return dp[amount];
    }
}
