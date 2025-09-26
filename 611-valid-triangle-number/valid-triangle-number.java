class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int cnt=0;
        for(int i=n-1;i>=2;i--){
            int j=0;
            int k=i-1;
            while(j<k){
                int sum=nums[j]+nums[k];
                if(sum>nums[i]){
                    cnt+=(k-j);
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return cnt;
    }
}