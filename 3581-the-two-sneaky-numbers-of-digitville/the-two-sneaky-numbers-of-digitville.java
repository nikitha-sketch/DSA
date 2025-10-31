class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        /*Map<Integer,Integer>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();
        int n=nums.length;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer>map1:map.entrySet()){
            if(map1.getValue()>=2){
                list.add(map1.getKey());
            }
        }
         int arr[]=new int[list.size()];
         for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
         }
        return arr;
        */
        List<Integer>list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int cnt=1;
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    cnt++;
                }
            }
            if(cnt>=2 && !list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        int arr[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}