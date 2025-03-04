class Solution {
    public int totalHammingDistance(int[] nums) {
       int total=0;
       int n=nums.length;
       for(int bit=0;bit<32;bit++){
            int countOnes=0;
            for(int num:nums){
                countOnes+=(num>>bit)&1;
            }
            int countZeroes=n-countOnes;
            total+=countOnes*countZeroes;
       }
       return total;
    }
}