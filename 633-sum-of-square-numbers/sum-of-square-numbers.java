class Solution {
    public boolean judgeSquareSum(int c) {
       /* int sum=0;
        for(int i=0;i<c;i++){
            sum+=(i*i);
            if(c==sum)return true;
        }
        return false;*/

        long left=0;
        long right=(long)Math.sqrt(c);
        while(left<=right){
            long sum=left*left+right*right;
            if(sum==c)return true;
            else if(sum<c){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }
}