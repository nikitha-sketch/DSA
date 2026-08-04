class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int small=nums[0];
        int large=nums[n-1];
        List<Integer>list=new ArrayList<>();
        int j=0;
        for(int i=small;i<=large;i++){
            if(j<=nums.length && nums[j]==i){
                j++;
            }
            else{
                list.add(i);
            }
        }
        return list;
    }
}