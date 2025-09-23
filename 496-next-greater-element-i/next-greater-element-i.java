class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            int num=nums1[i];
            int index=-1;
            for(int j=0;j<m;j++){
                if(num==nums2[j]){
                    index=j;
                    break;
                }
            }

            int nextGreater=-1;
            for(int k=index+1;k<m;k++){
                if(nums2[k]>num){
                    nextGreater=nums2[k];
                    break;
                }
            }
            result[i]=nextGreater;
        }
        return result;
    }
}