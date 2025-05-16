class Solution {
    public int findMaximumXOR(int[] nums) {
       

        int mask=0;
        int max=0;
        for(int i=31;i>=0;i--){
            mask=mask|(1<<i);
            Set<Integer>set=new HashSet<>();
            for(int num:nums){
                set.add(num&mask);
            }
            int tryNewMax=max|(1<<i);
            for(int firstele:set){
                if(set.contains(firstele^tryNewMax)){
                    max=tryNewMax;
                    break;
                }
            }
        }
        return max;
    }
}