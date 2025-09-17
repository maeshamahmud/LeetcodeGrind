class Solution {
    public int coinChange(int[] coins, int amount) {
        int MAX_INTEGER = amount+1;
        int[] dp = new int[MAX_INTEGER]; //12
        for(int i = 0; i<dp.length;i++){
            dp[i]=amount+1;
        }
        dp[0]=0;
        //[0,1,1,2,2,1,]
        for(int i = 1; i<dp.length; i++){
            for(int j = 0; j<coins.length;j++){
                if(i-coins[j] >= 0){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount]>amount ? -1 : dp[amount];
    }
}