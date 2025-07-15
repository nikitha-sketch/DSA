class Solution {
    public void dfs(int node,int vis[],int isConnected[][]){
        vis[node]=1;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[node][j]==1 && vis[j]==0){
                dfs(j,vis,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int m=isConnected[0].length;
        int cnt=0;
        int vis[]=new int[isConnected.length];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,vis,isConnected);
            }
        }
        return cnt;
    }
}