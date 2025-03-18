class Solution {
    public int[] sortArrayByParity(int[] nums) {
       /* ArrayList<Integer>evenList=new ArrayList<>();
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
        return evenList.stream().mapToInt(Integer::intValue).toArray();*/
        /*ArrayList<Integer>list=new ArrayList<>();
        for(int num:nums){
            if(num%2==0){
                list.add(0,num);
            }
            else{
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();*/

        int n=nums.length;
        int left=0,right=n-1;
        while(left<right){
            if(nums[left]%2==0){
                left++;
            }
            else{
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                right--;
            }
        }
        return nums;
    }
}