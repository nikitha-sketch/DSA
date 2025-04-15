class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n=arr1.length;
        int m=arr2.length;
        int diff=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            boolean isvalid=true;
            for(int j=0;j<m;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    isvalid=false;
                    break;
                }
            }
            if(isvalid){
                cnt++;
            }
        }
        return cnt;
    }
}