class Solution {
    public int maxSubArray(int[] nums) {
        /*int sum=0;
        int max=Integer.MIN_VALUE;;
        int n=nums.length;
        int ansStart=-1,ansEnd=-1;
        int start=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            if(sum>max){
                max=sum;
               // ansStart=start;
               // ansEnd=i;
            }
            if(sum<0){
                sum=0;
                start=i+1;
            }
        }
        return max;*/
        int n=nums.length;
        int res=nums[0];
        int maxEnding=nums[0];
        for(int i=1;i<n;i++){
            maxEnding=Math.max(maxEnding+nums[i],nums[i]);
            res=Math.max(res,maxEnding);
        }
        return res;
    }
}