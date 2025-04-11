class Solution {
    public String countAndSay(int n) {
        if(n==1)return "1";
        String prev=countAndSay(n-1);
        StringBuilder str=new StringBuilder();
        int cnt=1;
        for(int i=1;i<prev.length();i++){
            if(prev.charAt(i)==prev.charAt(i-1)){
                cnt++;
            }
            else{
                str.append(cnt).append(prev.charAt(i-1));
                cnt=1;
            }
        }
        str.append(cnt).append(prev.charAt(prev.length()-1));
        return str.toString();
    }
}