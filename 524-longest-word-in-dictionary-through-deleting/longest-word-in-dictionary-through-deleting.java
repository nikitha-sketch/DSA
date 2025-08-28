class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        /*int n=dictionary.size();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            for(String s:dictionary){
                if(s.charAt(i)==dictionary[j].toString().get(j)){
                    str.append(s.charAt(i));
                }
            }
        }
        return str.toString();*/

        String result="";
        for(String word:dictionary){
            if(isSubSequence(word,s)){
                if (word.length() > result.length() || 
                   (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
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