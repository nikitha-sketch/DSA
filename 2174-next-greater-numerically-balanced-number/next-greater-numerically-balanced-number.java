class Solution {
    public boolean isBalanced(int x){
        int freq[]=new int[10];
        int t=x;
        while(t>0){
            freq[t%10]++;
            t/=10;
        }
        if(freq[0]>0)return false;
        for(int d=1;d<=9;d++){
            if(freq[d]!=d && freq[d]!=0){
                return false;
            }
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        int x=n+1;
        while(true){
            if(isBalanced(x))return x;
            x++;
        }
    }
}