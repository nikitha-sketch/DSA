class Solution {
    public int numberOfBeams(String[] bank) {
        int m=bank.length;
        int cnt=0;
        int prev=0;
        for(int i=0;i<m;i++){
            int cur=0;
            for(int j=0;j<bank[i].length();j++){
                if(bank[i].charAt(j)=='1'){
                    cur++;
                }
            }
            if(cur>0){
                cnt+=prev*cur;
                prev=cur;
            }
        }
        return cnt;

        /*
        int prev=0,result=0;
        for(String row:bank){
            int devices=0;
            for(char c:row.toCharArray()){
                if(c=='1')devices++;
            }
            if(devices>0){
                result+=prev*devices;
                prev=devices;
            }
        }
        return result;*/
    }
}