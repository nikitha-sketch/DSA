class Solution {
    public int[] twoSum(int[] numbers, int target) {
       /* Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int complement=target-numbers[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement)+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return new int[0];*/
        int left=0,right=numbers.length-1;
        while(left<right){
            int total=numbers[left]+numbers[right];
            if(total==target){
                return new int[]{left+1,right+1};
            }
            else if(total>target){
                right--;
            }
            else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}