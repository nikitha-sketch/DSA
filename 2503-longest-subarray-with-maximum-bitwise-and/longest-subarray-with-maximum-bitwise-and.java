class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int maxVal=0;
        for(int num:nums){
            if(num>maxVal){
                maxVal=num;
            }
        }
        int currentLen=0;
        int maxLen=0;
        for(int num:nums){
            if(num==maxVal){
                currentLen++;
            }
            else{
                maxLen=Math.max(currentLen,maxLen);
                currentLen=0;
            }
        }return Math.max(currentLen,maxLen);
    }
}