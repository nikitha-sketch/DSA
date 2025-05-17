
import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        List<Integer>arr=new ArrayList<>();
        for(int num:nums1)arr.add(num);
        for(int num:nums2)arr.add(num);
        Collections.sort(arr);
        int size=arr.size();
        if(size%2==1){
            return arr.get(size/2); 
        }
        else{
            return (arr.get(size/2-1)+arr.get(size/2))/2.0;
        }
    }
}