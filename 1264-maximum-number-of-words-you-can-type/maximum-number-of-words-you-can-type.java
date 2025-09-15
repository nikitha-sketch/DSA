/*class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int cnt=0;
        String words[]=text.split(" ");
        for(String word:words){
            boolean canType=true;
            for(int j=0;j<brokenLetters.length();j++){
                char brokenWord=brokenLetters.charAt(j);
                if(word.indexOf(brokenWord)!=-1){
                    canType=false;
                    break;
                }
            }
            if(canType)cnt++;
        }
        return cnt;
    }
}*/

import java.util.*;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenSet.add(c);
        }

        String[] words = text.split(" ");
        int cnt = 0;

        for (String word : words) {
            boolean canType = true;
            for (char ch : word.toCharArray()) {
                if (brokenSet.contains(ch)) { // quick lookup
                    canType = false;
                    break;
                }
            }
            if (canType) cnt++;
        }

        return cnt;
    }
}
