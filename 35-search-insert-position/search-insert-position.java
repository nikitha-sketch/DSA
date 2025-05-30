class Solution {
    public int searchInsert(int[] nums, int target) {
        /*int n=nums.length;
        int low=0,high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;*/

        if(nums[nums.length-1]<target)return nums.length;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i])return i;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<target && nums[i]>target)return i;
        }
        return 0;
    }
}