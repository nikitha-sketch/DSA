class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        int res=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int count:map.values()){
            if(count==1)return -1;

            res+=count/3;
            if(count%3!=0)res++;
        }
        return res;
    }
}