class Solution {
    /*public void swap(int nums1[],int nums2[],int index1,int index2){
        if(nums1[index1]>nums2[index2]){
            int temp=nums1[index1];
            nums1[index1]=nums2[index2];
            nums2[index2]=temp;
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=m+n;
        int gap=(len/2)+(len%2);
        while(gap>0){
            int left=0;
            int right=left+gap;
            while(right<len){
                if(left<n && right>=n){
                    swap(nums1,nums2,left,right-n);
                }
                else if(left>=n){
                    swap(nums2,nums2,left-n,right-n);
                }
                else{
                    swap(nums1,nums1,left,right);
                }
                left++;
                right++;
            }
            if(gap==1)break;
            gap=(gap/2)+(gap%2);
            
        }
    }*/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int p3=nums1.length-1;
        while(p3>=0){
            int element1,element2;
            element1=(p1>=0)?nums1[p1]:Integer.MIN_VALUE;
            element2=(p2>=0)?nums2[p2]:Integer.MIN_VALUE;
            if(element1>element2){
                nums1[p3]=element1;
                p3--;
                p1--;
            }
            else{
                nums1[p3]=element2;
                p3--;
                p2--;
            }
        }
    }
}