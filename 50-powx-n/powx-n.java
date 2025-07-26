class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (x == 0) return 0.0;   
        long N = n; // Use long to handle overflow for n = Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        while (N > 0) {
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            N /= 2;
        }
        
        return result;

       /* long N=n;
        if(n<0){
            x=1/x;
            N=-N;
        }
        double s=1.0;
        for(int i=1;i<=N;i++){
            s=s*x;
        }
        return s;*/
    }
}