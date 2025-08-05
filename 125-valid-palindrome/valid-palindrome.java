class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return palindromeHelper(s,0,s.length()-1);
    }
    private boolean palindromeHelper(String s,int left,int right){
        if(left>=right){
            return true;
        }
        if(s.charAt(left)!=s.charAt(right)){
            return false;
        }
        return palindromeHelper(s,left+1,right-1);
    }
}