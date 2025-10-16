class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        /*Map<Integer,Integer>map=new HashMap<>();
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
        }*/

        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i] = ((nums[i] % value) + value) % value;
        }

        int freq[]=new int[value];
        for(int num:nums){
            freq[num%value]++;
        }

        int ans=0;
        while(true){
            int mod=ans%value;
            if(freq[mod]==0){
                return ans;
            }
            freq[mod]--;
            ans++;
        }
    }
}