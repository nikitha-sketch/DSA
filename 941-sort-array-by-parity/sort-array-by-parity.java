class Solution {
    public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer>evenList=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                evenList.add(nums[i]);
            }
        }
        ArrayList<Integer>oddList=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                oddList.add(nums[i]);
            }
        }
        evenList.addAll(oddList);
        //return evenList;
        return evenList.stream().mapToInt(Integer::intValue).toArray();
    }
}