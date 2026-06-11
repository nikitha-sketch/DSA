class Solution {
    private static final long MOD = 1000000007L;
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Queue<Integer>queue=new LinkedList<>();
        boolean visited[]=new boolean[n+1];
        queue.offer(1);
        visited[1]=true;
        int depth=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            depth++;
            for(int i=0;i<size;i++){
                int node=queue.poll();
                for(int nei:graph.get(node)){
                    if(!visited[nei]){
                        visited[nei]=true;
                        queue.offer(nei);
                    }
                }
            }
        }
        return (int)modPow(2,depth-1);
    }
    private long modPow(long base,int exp){
        if(exp<0)return 1;
        long result=1;
        while(exp>0){
            if((exp&1)==1){
                result=(result*base)%MOD;
            }
            base=(base*base)%MOD;
            exp>>=1;
        }
        return result;
    }
}