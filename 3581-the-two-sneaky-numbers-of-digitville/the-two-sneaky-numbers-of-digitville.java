class Solution {
    public int[] getSneakyNumbers(int[] nums) {
         Map<Integer, Long> map = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        return map.entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .mapToInt(Map.Entry::getKey)
            .toArray();
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
        /*List<Integer>list=new ArrayList<>();
        int n=nums.length;
        int arr[]=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    cnt++;
                }
                if(cnt>=2)list.add(nums[i]);
            }
            
        }
        return arr;*/
        
    }
}