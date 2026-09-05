class Solution {
    public int firstStableIndex(int[] nums, int k) {
        /*int n=nums.length;
        int min[]=new int[n];
        int max=new int[n];
        int cnt=0;
        int result=0;
        max[0]=nums[0];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                max[i]=Math.max(max,nums[i]);
                min[i]=Math.min(min,nums[i]);
                result=max-min;
            }
        }
        if(result<k)cnt++;
        return cnt;*/
        int n=nums.length;
        int suffix[]=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            suffix[i]=min;
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            int score=max-suffix[i];
            if(score<=k)return i;
        }
        return -1;
    }
}