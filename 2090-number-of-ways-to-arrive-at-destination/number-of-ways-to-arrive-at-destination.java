class Solution {
    static final int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int w=road[2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }

        //distance array
        long dist[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;

        //ways array
        int ways[]=new int[n];
        ways[0]=1;

        PriorityQueue<long[]>pq=new PriorityQueue<>(Comparator.comparingLong(a->a[1]));
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long cur[]=pq.poll();
            int node=(int)cur[0];
            long d=cur[1];
            if(d>dist[node])continue;

            for(int nei[]:graph.get(node)){
                int next=nei[0];
                long w=nei[1];
                long newDist=d+w;

                if (newDist < dist[next]) {
                dist[next] = newDist;
                ways[next] = ways[node]; // inherit path count
                pq.offer(new long[]{next, newDist});
                } else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }
        return (int) (ways[n - 1] % MOD);
    }
}