class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int ans=0;
        for(int l=0;l<n;l++){
            int targetCnt=0;
            for(int r=l;r<n;r++){
                if(nums[r]==target){
                    targetCnt++;
                }
                int len=r-l+1;
                if(targetCnt>len/2){
                    ans++;
                }
            }
        }
        return ans;
    }
}