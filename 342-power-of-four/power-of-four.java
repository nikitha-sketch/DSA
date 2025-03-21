class Solution {
    public boolean isPowerOfFour(int n) {
        /*for(int i=0;i<n;i++){
            if(n==Math.pow(4,i))return true;
        }
        return false;*/

        while(n>=4){
            if(n%4!=0){
                return false;
            }
            else{
                n=n/4;
            }
        }
        return n==1;
    }
}