class Solution {
    /*public void dfs(int row,int col,int image[][],int ans[][],int color,int inicolor,int delRow[],int delCol[]){
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==inicolor && ans[nrow][ncol]!=color){
                dfs(nrow,ncol,image,ans,color,inicolor,delRow,delCol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor=image[sr][sc];
        int ans[][]=image;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        dfs(sr,sc,image,ans,color,inicolor,delRow,delCol);
        return ans;
    }*/

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor=image[sr][sc];
        if(originalColor==color)return image;
         
         int rows=image.length;
         int cols=image[0].length;
          Queue<int[]>queue=new LinkedList<>();
          queue.add(new int[]{sr,sc});
          image[sr][sc]=color;
          int directions[][]={{0,1},{1,0},{0,-1},{-1,0}};
          while(!queue.isEmpty()){
            int cell[]=queue.poll();
            int r=cell[0],c=cell[1];
            for(int dir[]:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && image[nr][nc]==originalColor){
                    queue.add(new int[]{nr,nc});
                    image[nr][nc]=color;
                }
            }
          }
          return image;
    }
}