class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        /*Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
                set.remove(nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }
        return nums[i];*/
        ArrayList<Integer>list=new ArrayList<>();
        Map<Integer,Integer>freq=new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:freq.entrySet()){
            if(entry.getValue()>=2){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}