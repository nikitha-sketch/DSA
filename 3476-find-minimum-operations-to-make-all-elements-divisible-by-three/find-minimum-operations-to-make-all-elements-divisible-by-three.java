class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int add=nums[i]+1;
            int sub=nums[i]-1;
            if(add%3==0 || sub%3==0){
                cnt++;
            }
        }
        return cnt;
    }
}