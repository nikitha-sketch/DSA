class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][][]=new int[m][n][k];
        int MOD = 1_000_000_007;
        dp[0][0][grid[0][0]%k]=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int r=0;r<k;r++){
                    int val=grid[i][j];
                    if(i==0 && j==0)continue;
                    if(i>0){
                        int prevCnt=dp[i-1][j][r];
                        int newRem=(r+val)%k;
                        dp[i][j][newRem]=(dp[i][j][newRem]+prevCnt)%MOD;
                    }
                    if(j>0){
                        int prevCnt=dp[i][j-1][r];
                        int newRem=(r+val)%k;
                        dp[i][j][newRem]=(dp[i][j][newRem]+prevCnt)%MOD;
                    }
                }
            }
        }
        return dp[m-1][n-1][0];
    }
}