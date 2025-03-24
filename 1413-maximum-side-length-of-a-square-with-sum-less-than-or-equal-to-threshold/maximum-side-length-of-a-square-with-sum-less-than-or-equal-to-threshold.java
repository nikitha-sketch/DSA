class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n=mat.length;
        int m=mat[0].length;
        int prefix[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefix[i][j]=mat[i-1][j-1]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
            }
        }
        int left=0,right=Math.max(n,m),maxLen=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(canFindSquare(prefix,mid,threshold)){
                maxLen=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return maxLen;
    }
        public boolean canFindSquare(int prefix[][],int size,int threshold){
            for(int i=size;i<prefix.length;i++){
                for(int j=size;j<prefix[0].length;j++){
                    int sum=prefix[i][j]-prefix[i - size][j] - prefix[i][j - size] + prefix[i - size][j - size];
                    if(sum<=threshold)return true;
                }
            }
            return false;
        }
}