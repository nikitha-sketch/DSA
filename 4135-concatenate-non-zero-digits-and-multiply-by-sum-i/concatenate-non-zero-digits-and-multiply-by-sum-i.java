class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb=new StringBuilder();
        int sum=0;
        while(n!=0){
            int rem=n%10;
            if(rem!=0){
                sb.insert(0,rem);
                sum+=rem;
            }
            n=n/10;
        }
        if(sb.length()==0)return 0;
        long result=Long.parseLong(sb.toString());
        return result*sum;
    }
}