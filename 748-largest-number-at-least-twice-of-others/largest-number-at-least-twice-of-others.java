class Solution {
    public int dominantIndex(int[] nums) {
        /*Arrays.sort(nums);
        int largeEle=nums.length-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]+nums[i]<=largeEle){
                return nums.indexOf(largeEle);
            }
        }
        return -1;*/

        int n=nums.length;
        int large=nums[0];
        int index=0;
        for(int i=1;i<n;i++){
            if(nums[i]>large){
                large=nums[i];
                index=i;
            }
        }
        for(int i=0;i<n;i++){
            if(2*nums[i]>large&&i!=index){
                return -1;
            }
        }
        return index;
    }
}