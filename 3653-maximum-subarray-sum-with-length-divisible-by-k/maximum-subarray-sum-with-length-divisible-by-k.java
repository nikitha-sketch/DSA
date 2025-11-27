class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        // 1. Prefix sum
        int n = nums.length;
        long[] pre = new long[n];

        long sum = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            pre[i] = sum;
        }

        // 2. dp
        long[] minPre = new long[n];
        long res = Long.MIN_VALUE;

        long prevMinPre = Long.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int len = i + 1;
            prevMinPre = i-k < 0 ? 0 : minPre[i-k];
            minPre[i] = i+1 >= k ? Math.min(pre[i], prevMinPre) : pre[i];

            if(i+1 >= k){
                res = Math.max(res, pre[i] - prevMinPre);
            }
        }

        return res;
    }
}