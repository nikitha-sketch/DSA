class Solution {
    public String[] findWords(String[] words) {
        List<String>list=new ArrayList<>();
        String row1="qwertyuiopQWERTYUIOP";
        String row2="asdffghjklASDFGHJKL";
        String row3="zxcvbnmZXCVBNM";
        for(String word:words){
            if(belongToWord(word,row1)||belongToWord(word,row2)||belongToWord(word,row3)){
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
    public boolean belongToWord(String word,String row){
        for(char c:word.toCharArray()){
            if(row.indexOf(c)==-1)return false;
        }
        return true;
    }
}