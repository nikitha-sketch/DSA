class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=1000000007;
        int xor=0;
        for(int q[]:queries){
            int li=q[0];
            int ri=q[1];
            int ki=q[2];
            int vi=q[3];
            for(int idx=li;idx<=ri;idx+=ki){
                nums[idx]=(int)((1l*nums[idx]*vi)%mod);
            }
        }
        for(int num:nums){
            xor^=num;
        }
        return xor;
    }
}