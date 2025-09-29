class Solution {
    public int minScoreTriangulation(int[] values) {
        /*int n=values.length;
        int dp[][]=new int[n][n];

        for(int len=2;len<n;len++){
            for(int i=0;i+len<n;i++){
                int j=i+len;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]+values[i]*values[j]*values[k]);
                }
            }
        }
        return dp[0][n-1];*/
        int n=values.length;
        int dp[][]=new int[n][n];
        return solve(values,0,n-1,dp);
    }

    public int solve(int values[],int i,int j,int dp[][]){
        if(j-i<2)return 0;
        if(dp[i][j]!=0)return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost=values[i]*values[j]*values[k]+solve(values,i,k,dp)+solve(values,k,j,dp);
            min=Math.min(min,cost);
        }
        return dp[i][j]=min;
    }
}