//this passes only 51/57 testcase this is brute force method
/*class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int ans[]=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                long prod=(long)spells[i]*potions[j];
                if(prod>=success){
                    cnt++;
                }
            }
            ans[i]=cnt;
            cnt=0;
        }
        return ans;
    }
}*/


class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int ans[]=new int[n];
        Arrays.sort(potions);

        for(int i=0;i<n;i++){
            long spell=spells[i];
           // long minPotion=(success+spell-1)/spell;
            long minPotion=(long) Math.ceil((double) success / spell);
            int idx=lowerBound(potions,minPotion);
            ans[i]=m-idx;
        }
        return ans;
    }
    public int lowerBound(int arr[],long target){
        int left=0,right=arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
}