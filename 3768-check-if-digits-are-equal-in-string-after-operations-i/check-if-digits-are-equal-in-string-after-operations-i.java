class Solution {
    public boolean hasSameDigits(String s) {
        int n=s.length();
        int digit[]=new int[n];
        for(int i=0;i<n;i++){
            digit[i]=s.charAt(i)-'0';
        }
        while(n>2){
            for(int i=0;i<n-1;i++){
                digit[i]=(digit[i]+digit[i+1])%10;
            }
            n--;
        }
        return digit[0]==digit[1];
    }
}