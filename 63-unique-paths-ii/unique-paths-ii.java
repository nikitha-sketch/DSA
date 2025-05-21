class Solution {
    //int mod = (int)(1e9+7);
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        return mazeObstacles(n,m,obstacleGrid);
    }
    public int mazeObstacles(int n,int m,int obstacleGrid[][]){
        long prev[]=new long[m];
        for(int i=0;i<n;i++){
            long cur[]=new long[m];
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1)cur[j]=0;
                else if(i==0 && j==0)cur[j]=1;
                else{
                    long up=0,left=0;
                    if(i>0)up=prev[j];
                    if(j>0)left=cur[j-1];
                    cur[j]=up+left;
                }
            }
            prev=cur;
        }
        return (int)prev[m-1];
    }
}

