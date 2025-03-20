class Solution {
    public int heightChecker(int[] heights) {
        int n=heights.length;
        int cnt=0;
        int arr[]=heights.clone();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i]!=heights[i]){
                cnt++;
            }
        }
        return cnt;
    }
}