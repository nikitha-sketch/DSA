class Solution {
    public boolean detectCapitalUse(String word) {
        

        /*if(word.equals(word.toUpperCase())){
            return true;
        }
        if(word.equals(word.toLowerCase())){
            return true;
        }
        if(Character.isUpperCase(word.charAt(0))&&word.substring(1).equals(word.substring(1).toLowerCase())){
            return true;
        }
        return false;*/

        int capitals=0;
        for(char ch:word.toCharArray()){
            if(Character.isUpperCase(ch)){
                capitals++;
            }
        }
        if(capitals==0 ||capitals==word.length())return true;
        return capitals==1 && Character.isUpperCase(word.charAt(0));
    }
}