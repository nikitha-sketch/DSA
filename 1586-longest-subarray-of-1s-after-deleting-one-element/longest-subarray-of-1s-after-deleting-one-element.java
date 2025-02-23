class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int left=0,zeroes=0,ans=0;
        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zeroes++;
            }
            while(zeroes>1){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            ans=Math.max(ans,right-left+1-zeroes);
        }
        return (ans==n)?ans-1:ans;
    }
}