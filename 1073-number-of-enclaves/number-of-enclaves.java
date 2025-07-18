class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        Queue<Pair>queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1 && vis[i][j]==0){
                        queue.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }

        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};

        while(!queue.isEmpty()){
            int row=queue.peek().first;
            int col=queue.peek().second;
            queue.remove();
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && vis[nRow][nCol]==0){
                    queue.add(new Pair(nRow,nCol));
                    vis[nRow][nCol]=1;
                }
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}