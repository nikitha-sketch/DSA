class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        /*int n=nums.length;
        int cnt=0;
        for(int i=1;i<n;i++){
            if (nums[i] <= nums[i - 1]) {
                int diff = (nums[i - 1] + 1) - nums[i];
                nums[i] = nums[i - 1] + 1;
                cnt += diff;
            }
        }*/
        var i=0;
        var cnt=0;
        for(var n:nums){
            i=Math.max(i,n);
            cnt+=i++ -n;
        }
        return cnt;
    }
}