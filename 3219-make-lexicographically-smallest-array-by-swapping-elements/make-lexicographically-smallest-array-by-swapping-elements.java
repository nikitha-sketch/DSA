class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        /*int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
                int res=Math.abs(nums[i]-nums[i+1]);
                if(res<=limit){
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                }
        
        }
        return nums;*/
        int res[]=nums.clone();
        Arrays.sort(res);
        List<List<Integer>>grps=new ArrayList<>();
        Map<Integer,Integer>map=new HashMap<>();
        int id=-1;
        for(int i=0;i<res.length;i++){
            if(i==0 || res[i]-res[i-1]>limit){
                grps.add(new ArrayList<>());
                id++;
            }
            grps.get(id).add(res[i]);
            map.put(res[i],id);
        }
        int idx[]=new int[grps.size()];
        for(int i=0;i<nums.length;i++){
            int cur=map.get(nums[i]);
            nums[i]=grps.get(cur).get(idx[cur]);
            idx[cur]++;
        }
        return nums;
    }
}