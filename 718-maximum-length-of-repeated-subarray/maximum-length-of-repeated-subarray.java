class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int dp[][]=new int[n+1][m+1];
        int ans=0;
        for(int i=0;i<n;i++)dp[i][0]=0;
        for(int j=0;j<=m;j++)dp[0][j]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
}