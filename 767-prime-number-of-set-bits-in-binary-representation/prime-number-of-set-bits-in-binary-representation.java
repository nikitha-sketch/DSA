class Solution {
    public int countPrimeSetBits(int left, int right) {
        int result=0;
        for(int i=left;i<=right;i++){
            int num=bitCounts(i);
            if(isPrime(num)){
                result++;
            }
        }
        return result;
    }
    public int bitCounts(int n){
        int cnt=0;
        while(n!=0){
            n=n&(n-1);
            cnt++;
        }
        return cnt;
    }
    public boolean isPrime(int n){
        if(n<2)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}