class Solution {
    public int smallestNumber(int n) {
       /* int x=1;
        while(x<n){
            x=(x<<1)|1;
        }
        return x;*/

        for(int i=n;;i++){
            String num=Integer.toBinaryString(i);
            boolean allones=true;
            for(char ch:num.toCharArray()){
                if(ch!='1'){
                    allones=false;
                    break;
                }
            }
            if(allones){
                return i;
            }
        }
    }
}