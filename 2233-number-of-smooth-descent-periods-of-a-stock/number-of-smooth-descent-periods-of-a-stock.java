class Solution {
    public long getDescentPeriods(int[] prices) {
        int n=prices.length;
        long cnt=1;
        long result=1;
        for(int i=1;i<n;i++){
            if(prices[i]==prices[i-1]-1){
                cnt++;
            }
            else{
                cnt=1;
            }
            result+=cnt;
        }
        return result;
    }
}