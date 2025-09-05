class Solution {
    public boolean isAnagram(String s, String t) {
       /* if(s.length()!=t.length())return false;
        char sArray[]=s.toCharArray();
        char tArray[]=t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray,tArray);*/
        if(s.length()!=t.length())return false;
        int freq[]=new int[256];

        for(char ch:s.toCharArray()){
            freq[ch]++;
        }

        for(char ch:t.toCharArray()){
            freq[ch]--;
            if(freq[ch]<0)return false;
        }

        for(int cnt:freq){
            if(cnt!=0)return false;
        }

        return true;
    }
}