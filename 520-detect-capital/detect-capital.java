class Solution {
    public boolean detectCapitalUse(String word) {
        /*for(int i=0;i<word.length();i++){
            if(word.isUpperCase||word.isLowerCase||word.charAt(0).isUpper)return true;
        }
        return false;*/

        if(word.equals(word.toUpperCase())){
            return true;
        }
        if(word.equals(word.toLowerCase())){
            return true;
        }
        if(Character.isUpperCase(word.charAt(0))&&word.substring(1).equals(word.substring(1).toLowerCase())){
            return true;
        }
        return false;
    }
}