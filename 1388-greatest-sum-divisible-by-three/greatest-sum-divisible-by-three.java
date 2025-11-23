class Solution {
    public int maxSumDivThree(int[] nums) {
       /* int dp[]=new int[]{0,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int num:nums){
            int next[]=dp.clone();
            for(int r=0;r<3;r++){
                int newR=(r+num)%3;
                next[newR]=Math.max(next[newR],dp[r]+num);
            }
            dp=next;
        }
        return dp[0];*/

        int[] dp = new int[3];
        
        for (int num : nums) {
            int[] current = dp.clone();
            
            for (int sum : current) {
                int newSum = sum + num;
                int remainder = newSum % 3;
                dp[remainder] = Math.max(dp[remainder], newSum);
            }
        }
        
        return dp[0];
    }
}