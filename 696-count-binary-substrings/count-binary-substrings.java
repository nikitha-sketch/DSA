class Solution {
    public int countBinarySubstrings(String s) {
        int total=0;
        int prevGrp=0,currGrp=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                currGrp++;
            }
            else{
                total+=Math.min(currGrp,prevGrp);
                prevGrp=currGrp;
                currGrp=1;
            }
        }
        total+=Math.min(currGrp,prevGrp);
        return total;
    }
}