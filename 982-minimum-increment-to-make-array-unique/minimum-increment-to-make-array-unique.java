class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int cnt=0;
        for(int i=1;i<n;i++){
            if (nums[i] <= nums[i - 1]) {
                int diff = (nums[i - 1] + 1) - nums[i];
                nums[i] = nums[i - 1] + 1;
                cnt += diff;
            }
        }
        return cnt;
    }
}