class Solution {
    public int calculate(String s) {
        Stack<Integer>st=new Stack<>();
        int number=0;
        int sign=1;
        int result=0;
        for(char ch:s.toCharArray()){
            if(ch=='+'){
                result+=sign*number;
                number=0;
                sign=1;
            }
            else if(ch=='-'){
                result+=sign*number;
                number=0;
                sign=-1;
            }
            else if(ch=='('){
                st.add(result);
                st.add(sign);
                result = 0;
                sign = 1;
            }
            else if(ch==')'){
                result += sign * number;
                number = 0;
                result *= st.pop();
                result += st.pop();
            }
            else if(ch != ' ') {
                number = number * 10 + (ch - '0');
            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
}