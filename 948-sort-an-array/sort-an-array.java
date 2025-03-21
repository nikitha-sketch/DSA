class Solution {
    public int[] sortArray(int[] nums) {
       /* int arr[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                int temp=nums[i];
                nums[i]=nums[i-1];
                nums[i-1]=temp;
                arr[i]=nums[i];
            }
        }
        return arr;*/
        Arrays.sort(nums);
        return nums;
    }
}