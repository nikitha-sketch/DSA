class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String>hp=new HashSet<>();
        String ans="";
        for(int i=0;i<words.length;i++){
            String s=words[i];
            if(s.length()==1 || hp.contains(s.substring(0,s.length()-1))){
                if(s.length()>ans.length()){
                    ans=s;                                      
                }
                hp.add(s);
            }
        }
        return ans;
    }
}