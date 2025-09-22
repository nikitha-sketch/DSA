class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length;
        if(n==1)return 1;
        Map<Integer,Integer>map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            int freq=map.getOrDefault(num,0)+1;
            map.put(num,freq);
            max=Math.max(max,freq);
        }
        int result=0;
        for(int freq:map.values()){
            if(freq==max){
                result+=freq;
            }
        }
        return result;
    }
}