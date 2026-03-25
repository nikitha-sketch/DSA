class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long total=0;
        for(int row[]:grid){
            for(int val:row){
                total+=val;
            }
        }
        //for horizontal cut
        long cur=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m;j++){
                cur+=grid[i][j];
            }
            if(cur*2==total)return true;
        }
        cur=0;
        for(int j=0;j<m-1;j++){
            for(int i=0;i<n;i++){
                cur+=grid[i][j];
            }
            if(cur*2==total)return true;
        }
        return false;
    }   
}