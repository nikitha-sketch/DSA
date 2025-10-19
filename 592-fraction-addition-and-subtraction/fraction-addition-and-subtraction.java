class Solution {
    public String fractionAddition(String expression) {
        if(expression.charAt(0)!='-'){
            expression="+"+expression;
        }

        int numerator=0;
        int denominator=1;
        int i=0;
        int n=expression.length();
        while(i<n){
            int sign=(expression.charAt(i)=='+')?1:-1;
            i++;
            int num=0;
            while(i<n && Character.isDigit(expression.charAt(i))){
                num=num*10+(expression.charAt(i)-'0');
                i++;
            }
            num*=sign;
            i++;

            int den=0;
            while(i<n && Character.isDigit(expression.charAt(i))){
                den=den*10+(expression.charAt(i)-'0');
                i++;
            }

            numerator=numerator*den+num*denominator;
            denominator=denominator*den;

            int g=gcd(Math.abs(numerator),denominator);
            numerator/=g;
            denominator/=g;
        }
        return numerator+"/"+denominator;
    }
    public int gcd(int a,int b){
        return (b==0)?a:gcd(b,a%b);
    }
}