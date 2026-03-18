class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        /*int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        int prefix[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                prefix[i][j]=grid[i][j];
                if(i>0)prefix[i][j]+=prefix[i-1][j];//top
                if(j>0)prefix[i][j]+=prefix[i][j-1];//left
                if(i>0 && j>0)prefix[i][j]-=prefix[i-1][j-1];//overlap
                if(prefix[i][j]<=k){
                    cnt++;
                }
            }
        }
        return cnt;*/
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        int prefix[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                prefix[i+1][j+1]=grid[i][j]+prefix[i+1][j]+prefix[i][j+1]-prefix[i][j];
                if(prefix[i+1][j+1]<=k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}