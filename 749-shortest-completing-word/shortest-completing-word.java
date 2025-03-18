class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int licenseFreq[]=new int[26];
        for(char c:licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                licenseFreq[Character.toLowerCase(c)-'a']++;
            }
        }
        String result=null;
        for(String word:words){
            if(isCompletingWord(word.toLowerCase(),licenseFreq)){
                if(result==null || word.length()<result.length()){
                    result=word;
                }
            }
        }
        return result;
    }
    public boolean isCompletingWord(String word,int licenseFreq[]){
        int wordFreq[]=new int[26];
        for(char c:word.toCharArray()){
            wordFreq[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(licenseFreq[i]>wordFreq[i]){
                return false;
            }
        }
        return true;
    } 
}