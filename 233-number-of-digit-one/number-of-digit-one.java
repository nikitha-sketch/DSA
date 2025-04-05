class Solution {
    public int countDigitOne(int n) {
       /*int arr[]=new int[n+1];
       int cnt=0;
       for(int i=1;i<=n;i++){
            arr[i]+=i;
       }
       for(int num:arr){
        String str=String.valueOf(num);
        for(char ch:str.toCharArray()){
            if(ch=='1'){
                cnt++;
            }
        }
       }
       return cnt;*/

       /*int cnt=0;
       for(int i=1;i<=n;i++){
        int num=i;
        while(num>0){
            if(num%10==1){
                cnt++;
            }
            num=num/10;
        }
       }
       return cnt;*/

       int cnt=0;
       long factor=1;
       while(factor<=n){
        long lower=n%factor;
        long current=(n/factor)%10;
        long high=n/(factor*10);
        if(current==0){
            cnt+=high*factor;
        }
        else if(current==1){
            cnt+=high*factor+lower+1;
        }
        else{
            cnt+=(high+1)*factor;
        }
        factor*=10;
       }
        return cnt;
    }
}