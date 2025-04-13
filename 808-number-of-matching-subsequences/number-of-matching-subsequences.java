class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Boolean> memo = new HashMap<>();
        int count = 0;

        for (String word : words) {
            if (!memo.containsKey(word)) {
                memo.put(word, isSubsequence(s, word));
            }
            if (memo.get(word)) {
                count++;
            }
        }
        return count;
    }
    public boolean isSubsequence(String s,String word){
        int i=0,j=0;
        while(i<s.length()&&j<word.length()){
            if(s.charAt(i)==word.charAt(j)){
                j++;
            }
            i++;
        }
        return j==word.length();
    }
}