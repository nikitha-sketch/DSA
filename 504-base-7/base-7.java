class Solution {
    public String convertToBase7(int num) {
        if(num==0)return "0";
       boolean isNegative=num<0;
       num=Math.abs(num);
        StringBuilder str=new StringBuilder();
        while(num!=0){
            int n=num%7;
            str.append(n);
            num=num/7;
        }
        if(isNegative){
            str.append("-");
        }
        return str.reverse().toString();
       
    }
}