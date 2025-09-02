class Solution {
    public int f(int ind,int prev,int nums[],int n,int dp[][]){
        if(ind==n)return 0;
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];
        int len=0+f(ind+1,prev,nums,n,dp);
        if(prev==-1 || nums[ind]>nums[prev]){
            len=Math.max(len,1+f(ind+1,ind,nums,n,dp));
        }
        return dp[ind][prev+1]=len;
    }
    public int lengthOfLIS(int[] nums) {
        /*int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,1);
        int maxLIS=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLIS=Math.max(maxLIS,dp[i]);
        }
        return maxLIS;*/
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(0,-1,nums,n,dp);
    }
}