class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(canMakeAllZero(nums,i,-1))cnt++;
                if(canMakeAllZero(nums,i,1))cnt++;
            }
        }
        return cnt;
    }
        private boolean canMakeAllZero(int nums[],int start,int direction){
            int n=nums.length;
            int arr[]=nums.clone();
            int cur=start;
            while(cur>=0 && cur<n){
                if(arr[cur]==0){
                    cur+=direction;
                }
                else{
                    arr[cur]--;
                    direction*=-1;
                    cur+=direction;
                }
            }
            for(int val:arr){
                if(val!=0)return false;
            }
            return true;
        }
}