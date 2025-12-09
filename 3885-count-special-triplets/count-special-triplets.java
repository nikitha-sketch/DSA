class Solution {
    public int specialTriplets(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i:nums)max=Math.max(max,i);
        int rightFreq[]=new int[max+1];
        int leftFreq[]=new int[max+1];
        long count=0;
        for(int i:nums){
            rightFreq[i]++;
        }
        for(int i:nums){
            rightFreq[i]--;
            int req=i*2;
            if(i*2<=max){
                long leftCnt=leftFreq[i*2];
                long rightCnt=rightFreq[i*2];
                count=(count+(leftCnt*rightCnt))%1000000007;
            }
            leftFreq[i]++;
        }
        return (int)count;
    }
}