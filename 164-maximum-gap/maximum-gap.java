class Solution {
    public int maximumGap(int[] nums) {
       /* int n=nums.length;
        int arr[]=new int[n];
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            int diff=nums[i]-nums[i-1];
            arr[i]=diff;
        }
        Arrays.sort(arr);
        return arr[arr.length-1];*/

        int n=nums.length;
        Arrays.sort(nums);
        if(n<2)return 0;
        int max=0;
        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]-nums[i-1]);
        }
        return max;
    }
}