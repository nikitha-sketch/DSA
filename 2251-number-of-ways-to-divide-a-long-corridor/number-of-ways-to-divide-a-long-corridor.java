class Solution {
    public int numberOfWays(String corridor) {
       /* int n=corridor.length();
        int cnt=0;
        int ways=0;
        for(char ch:corridor.toCharArray()){
            if(ch=='S'){
                cnt++;

                if(cnt==2)ways++;
            }
        }
        return ways;
        */
        int mod=1_000_000_007;
        int a=1;
        int b=0,c=0;
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                a=(a+c)%mod;
                c=b;
                b=a;
                a=0;
            }
            else{
                a=(a+c)%mod;
            }
        }
        return c;
    }
}