class Solution {
    public int triangularSum(int[] nums) {
        /*int n=nums.length;
        for(int size=n;size>1;size--){
            for(int i=0;i<size-1;i++){
                nums[i]=(nums[i]+nums[i+1])%10;
            }
        }
        return nums[0];*/

        int n=nums.length;
        if(n==1)return nums[0];

        int next[]=new int[n-1];
        for(int i=0;i<n-1;i++){
            next[i]=(nums[i]+nums[i+1])%10;
        }
        return triangularSum(next);
    }
}