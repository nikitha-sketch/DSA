class Solution {
    public int arrayNesting(int[] nums) {
        int n=nums.length;
        HashSet<Integer>set=new HashSet<>();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int j=i;
            int cnt=0;
            while(!set.contains(nums[j])){
                set.add(nums[j]);
                j=nums[j];
                cnt++;
            }
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
}