class Solution {
    public int climbStairs(int n) {
        /*int prev2=1;
        int prev=1;
        for(int i=2;i<=n;i++){
            int current=prev2+prev;
            prev2=prev;
            prev=current;
        }
        return prev;*/

        //dp
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}