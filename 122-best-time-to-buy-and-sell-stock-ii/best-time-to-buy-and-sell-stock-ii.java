class Solution {
    /*public int f(int ind,int buy,int prices[],int n,int dp[][]){
        if(ind==n)return 0;
        int profit=0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        if(buy==1){
            profit=Math.max(-prices[ind]+f(ind+1,0,prices,n,dp),0+f(ind+1,1,prices,n,dp));
        }
        else {
            profit=Math.max(prices[ind]+f(ind+1,1,prices,n,dp),0+f(ind+1,0,prices,n,dp));
        }
        return dp[ind][buy]=profit;
    }*/
    public int maxProfit(int[] prices) {
        /*int n=prices.length;
        int dp[][]=new int[n][2];    
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        } 
        return f(0,1,prices,n,dp);*/
        
        /*int n=prices.length;
        int dp[][]=new int[n+1][2];
        dp[n][0]=dp[n][1]=0;
        int profit=0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                //int profiit=0;
                if(buy==1){
                    dp[ind][buy]=Math.max(-prices[ind]+dp[ind+1][0],0+dp[ind+1][1]);
                }
                else{
                    dp[ind][buy]=Math.max(prices[ind]+dp[ind+1][1],0+dp[ind+1][0]);
                }
            }
        }
        return dp[0][1];*/

        int n=prices.length;
        int aheadBuy=0,aheadNotBuy=0;
        for(int ind=n-1;ind>=0;ind--){
            int currBuy=Math.max(-prices[ind]+aheadNotBuy,aheadBuy);
            int currNotBuy=Math.max(prices[ind]+aheadBuy,aheadNotBuy);
            aheadBuy=currBuy;
            aheadNotBuy=currNotBuy;
        }
        return aheadBuy;
    }
    
}