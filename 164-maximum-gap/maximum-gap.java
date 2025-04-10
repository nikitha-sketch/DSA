class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        //int max=Integer.MIN_VALUE;
        int arr[]=new int[n];
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            int diff=nums[i]-nums[i-1];
            //max=Math.max(max,diff);
            arr[i]=diff;
        }
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
}