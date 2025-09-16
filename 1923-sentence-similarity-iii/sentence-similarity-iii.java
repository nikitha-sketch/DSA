class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String s1[]=sentence1.split(" ");
        String s2[]=sentence2.split(" ");

        int i=0;
        int j=s1.length-1;
        int k=s2.length-1;

        while(i<s1.length && i<s2.length && s1[i].equals(s2[i])){
            i++;
        }

        while(j>=i && k>=i && s1[j].equals(s2[k])){
            j--;
            k--;
        }
        return i>j || i>k;
    }
}