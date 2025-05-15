class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        /*int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=nums[i];
            for(int j=i+1;j<n;j++){
                sum+=nums[j];
                if(k!=0){
                    if(sum%k==0)return true;
                }
                else{
                    if(sum==0)return true;
                }
            }
        }
        return false;*/
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(k!=0){
                sum%=k;
            }
            if(map.containsKey(sum)){
                if(i-map.get(sum)>=2){
                    return true;
                }
            }
            else{
                map.put(sum,i);
            }
        }
        return false;
    }
}