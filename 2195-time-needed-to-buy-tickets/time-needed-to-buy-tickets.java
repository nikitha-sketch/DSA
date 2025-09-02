class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n=tickets.length;
        int minTickets=0;
        for(int i=0;i<n;i++){
            if(i<=k){
                minTickets+=Math.min(tickets[i],tickets[k]);
            }
            else{
                minTickets+=Math.min(tickets[i],tickets[k]-1);
            }
        }
        return minTickets;
    }
}