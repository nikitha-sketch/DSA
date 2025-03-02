class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Arrays.sort(nums);
        //return nums.length-1;
        /*int n=nums.length;
        int max=nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }*/
        Arrays.sort(nums);
        int n=nums.length-k;
        return nums[n];
    }
}