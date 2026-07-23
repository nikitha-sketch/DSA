class Solution {
    public int uniqueXorTriplets(int[] nums) {
        /*int n=nums.length;
        int xor=0;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=j;k<n;k++){
                    xor=nums[i]^nums[j]^nums[k];
                    set.add(xor);
                }
            }
        }
        return set.size();*/
        int n=nums.length;
        if(n<=2){
            return n;
        }
        int result=32- Integer.numberOfLeadingZeros(n);;
        return 1<<result;
    }
}