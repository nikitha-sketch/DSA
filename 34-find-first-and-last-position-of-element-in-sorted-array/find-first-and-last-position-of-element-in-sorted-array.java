class Solution {
  /*  public int firstOccurence(int nums[],int target){
        int low=0,high=nums.length-1;
        int first=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                first=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return first;
    }
    public int lastOccurence(int nums[],int target){
        int low=0,high=nums.length-1;
        int last=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int first=firstOccurence(nums,target);
        if(first==-1) return new int[] {-1,-1};
        int last=lastOccurence(nums,target);
        return new int[] {first,last};
    }*/

    public int[] searchRange(int nums[],int target){
        int n=nums.length;
        int first=-1,last=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                if(first==-1)first=i;
                last=i;
            }
        }
        int arr[]=new int[2];
       
            arr[0]=first;
            arr[1]=last;
            return arr;
        
    }
}