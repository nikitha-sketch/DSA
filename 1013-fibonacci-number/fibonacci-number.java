class Solution {
    public int fib(int n) {
        //return (n<=1)?n:fib(n-1)+fib(n-2);
        if(n<=1)return n;
        int prev2=0;
        int prev1=1;
        int cur;
        for(int i=2;i<=n;i++){
            cur=prev1+prev2;
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}