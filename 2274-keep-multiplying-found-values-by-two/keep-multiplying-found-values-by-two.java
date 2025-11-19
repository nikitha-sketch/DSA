class Solution {
    public int findFinalValue(int[] nums, int original) {
       /* int n=nums.length;
        Arrays.sort(nums);
        int value=original;
        for(int num:nums){
            if(num==value){
                value*=2;
            }
        }
        return value;   */
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int value = original;
        while (set.contains(value)) {
            value *= 2;
        }
        return value;
    }
}