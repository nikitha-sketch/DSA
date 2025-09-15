class Solution {
    public int kthGrammar(int n, int k) {
        if(n==0)return 1;
        int half=1<<(n-2);
        if(k<=half){
            return kthGrammar(n-1,k);
        }
        else{
            return 1-kthGrammar(n-1,k-half);
        }
    }
}