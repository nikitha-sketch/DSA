class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        int n=nums.length;
        for(int num:nums){
            list.add(num);
        }
        while(!list.isEmpty()){
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=-1 && !temp.contains(nums[i])){
                    temp.add(nums[i]);
                    list.remove(Integer.valueOf(nums[i]));
                    nums[i]=-1;
                }
            }
            result.add(temp);
        }
        return result;
    }
}