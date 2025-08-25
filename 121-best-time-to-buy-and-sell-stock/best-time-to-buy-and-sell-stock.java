class Solution {
    public int maxProfit(int[] prices) {
       /* int min_price=prices[0];
        int max_profit=0;
        for(int i=0;i<prices.length;i++){
            max_profit=Math.max(max_profit,prices[i]-min_price);
            min_price=Math.min(prices[i],min_price);
        }
        return max_profit;*/

        int n=prices.length;
        int min=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<n;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            int currentProfit=prices[i]-min;
            if(currentProfit>maxProfit){
                maxProfit=currentProfit;
            }
        }
        return maxProfit;
    }
}