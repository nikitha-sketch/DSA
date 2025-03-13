class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer>count=new HashMap<>();
        Map<Integer,Integer>firstIndex=new HashMap<>();
        Map<Integer,Integer>lastIndex=new HashMap<>();
        int degree=0;
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, count.get(nums[i]));
            
            firstIndex.putIfAbsent(nums[i], i);
            lastIndex.put(nums[i], i);
        }
        
        int minLength = nums.length;
        
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                minLength = Math.min(minLength, lastIndex.get(num) - firstIndex.get(num) + 1);
            }
        }
        
        return minLength;
    }
}