class Solution {
    public boolean checkRecord(String s) {
        int n=s.length();
        int cntA=0,cntP=0,cntL=0;
        for(int i=0;i<n;i++){
            
            if(s.charAt(i)=='A'){
                cntA++;
                if(cntA>=2)return false;
                cntL=0;
            }
            else if(s.charAt(i)=='L'){
                cntL++;
                if(cntL>=3)return false;
            }
            else{
                cntL=0;
            }
        }
        return true;
    }
}