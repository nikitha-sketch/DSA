class Solution {
    public int findLUSlength(String[] strs) {
        int n=strs.length;
        int ans=-1;

        for(int i=0;i<n;i++){
            boolean isSubSequence=false;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(isSubSequence(strs[i],strs[j])){
                    isSubSequence=true;
                    break;
                }
            }
            if(!isSubSequence){
                ans=Math.max(ans,strs[i].length());
            }
        }
        return ans;
    }
    public boolean isSubSequence(String s,String t){
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }
}