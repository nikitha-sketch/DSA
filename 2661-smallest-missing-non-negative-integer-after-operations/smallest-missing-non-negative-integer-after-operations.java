class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            int mod=((num%value)+value)%value;
            map.put(mod,map.getOrDefault(mod,0)+1);
        }

        int ans=0;
        while(true){
            int mod=ans%value;
            if(!map.containsKey(mod) || map.get(mod)==0){
                return ans;
            }
            map.put(mod,map.get(mod)-1);
            ans++;
        }
       // return ans;
    }
}