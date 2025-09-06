class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int prefixSum=0;
        int count=0;
        Map<Integer,Integer> mpp=new HashMap<>();
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            prefixSum+=nums[i];
            int remove=prefixSum-k;
            count+=mpp.getOrDefault(remove,0);
            mpp.put(prefixSum,mpp.getOrDefault(prefixSum,0)+1);
        }
        return count;
       /* int n=nums.length;
        int left=0,right=0,sum=0,maxLen=0;
        while(right<n){
            sum=sum+nums[right];
            while(sum>k){
                sum=sum-nums[left];
                left=left+1;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right=right+1;
        }
        return maxLen;*/
    }
}