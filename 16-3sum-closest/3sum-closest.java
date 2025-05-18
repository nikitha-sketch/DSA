class Solution {
    public int threeSumClosest(int[] nums, int target) {
        /*int n=nums.length;
        int x=target+1;
        int y=target-1;
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=n-1;k>=0;k--){
                    sum=nums[i]+nums[j]+nums[k];
                    if(sum==x || sum==y){
                        return sum;
                    }
                }
            }
        }
        return sum;*/

       /* int closestSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(Math.abs(target-sum)<Math.abs(target-closestSum))
                        closestSum=sum;
                }
            }
        }
        return closestSum;*/

        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target)return sum;
                if(Math.abs(target-sum)<Math.abs(target-closestSum)){
                    closestSum=sum;
                }
                if(sum<target)left++;
                if(sum>target)right--;
            }
        }
        return closestSum;
    }
}