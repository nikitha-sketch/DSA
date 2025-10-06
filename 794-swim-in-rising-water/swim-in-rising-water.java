class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean visited[][]=new boolean[n][n];
        pq.offer(new int[]{grid[0][0],0,0});
        int res=0;
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int cur[]=pq.poll();
            int height=cur[0],r=cur[1],c=cur[2];
            res=Math.max(res,height);
            if(r==n-1 && c==n-1)return res;
            if(visited[r][c])continue;
            visited[r][c]=true;
            for(int d[]:dirs){
                int nr=r+d[0],nc=c+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                    pq.offer(new int[]{grid[nr][nc],nr,nc});
                }
            }
        }
        return -1;
    }
}