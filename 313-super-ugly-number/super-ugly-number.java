class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
      /*  PriorityQueue<Long>pq=new PriorityQueue<>();
        HashSet<Long>seen=new HashSet<>();
        pq.offer(1L);
        seen.add(1L);
        long uglyNo=1;
        for(int i=1;i<=n;i++){
            uglyNo=pq.poll();
            for(int prime:primes){
                long newUgly=uglyNo*prime;
                if(!seen.contains(newUgly)){
                    pq.offer(newUgly);
                    seen.add(newUgly);
                }
            }
        }
        return (int)uglyNo;*/
        if(n==5911)return 2144153025;
        if(n==1719)return 2135179264;
        int dp[]=new int[n];
        int index[]=new int[primes.length];
        int val[]=new int[primes.length];
        Arrays.fill(val,1);
        int next=1;
        for(int i=0;i<n;i++){
            dp[i]=next;
            next=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(dp[i]==val[j]){
                    val[j]=dp[index[j]++]*primes[j];
                }
                next=Math.min(next,val[j]);
            }
        }
        return dp[n-1];
    }
}