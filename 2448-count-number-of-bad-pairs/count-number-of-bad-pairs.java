class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        long totalPairs=(long)n*(n-1)/2;
        Map<Long,Long>map=new HashMap<>();
        long goodPairs=0;
        for(int i=0;i<n;i++){
            long key=i-nums[i];
            long count=map.getOrDefault(key,0L);
            goodPairs+=count;
            map.put(key,count+1);
        }
        return totalPairs-goodPairs;
    }
}