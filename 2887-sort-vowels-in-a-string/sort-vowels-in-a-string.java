class Solution {
    public String sortVowels(String s) {
        List<Character>vowels=new ArrayList<>();
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                vowels.add(ch);
            }
        }
        Collections.sort(vowels);
        StringBuilder result=new StringBuilder();
        int index=0;
        for(char ch:s.toCharArray()){
            if(isVowel(ch)){
                result.append(vowels.get(index++));
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
    }
    public boolean isVowel(char ch){
        return "AEIOUaeiou".indexOf(ch)!=-1;
    }
}