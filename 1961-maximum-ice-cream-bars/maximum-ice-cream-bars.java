class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxcost=0;
        for(int cost:costs){
            maxcost=Math.max(cost,maxcost);
        }
        int freq[]=new int[maxcost+1];
        for(int cost:costs){
            freq[cost]++;
        }
        int cnt=0;
        for(int cost=1;cost<=maxcost;cost++){
            if(freq[cost]==0)continue;
            int canBuy=Math.min(freq[cost],coins/cost);
            cnt+=canBuy;
            coins-=canBuy*cost;
            if(coins<cost)continue;
        }
        return cnt;
    }
}