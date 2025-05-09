class Solution {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return count(n, 1, visited);
    }
    public int count(int n,int pos,boolean visited[]){
        if(pos>n)return 1;
        int total=0;
        for(int i=1;i<=n;i++){
            if(!visited[i]&&(pos%i==0||i%pos==0)){
                visited[i]=true;
                total+=count(n,pos+1,visited);
                visited[i]=false;
            }
        }
        return total;
    }
}