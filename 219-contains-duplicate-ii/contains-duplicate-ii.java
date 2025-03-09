class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       /* int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]&&Math.abs(i-j)<=k){
                    return true;
                }
            }
        }
        return false;*/
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int prev=map.get(nums[i]);
                if(Math.abs(i-prev)<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }
}