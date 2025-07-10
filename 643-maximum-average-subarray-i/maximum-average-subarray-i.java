class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        double maxAvg=-10001;
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        double avg=(double)sum/k;
        maxAvg=Math.max(avg, maxAvg);
        for(int i=k;i<nums.length;i++)
        {
            sum=sum+nums[i]-nums[i-k];
            avg=(double)sum/k;
            maxAvg=Math.max(avg, maxAvg);
        }
        return maxAvg;
    }
}