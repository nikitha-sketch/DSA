class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       /* List<Integer>result=new ArrayList<>();
        if(s.length()<p.length())return result;

        Map<Character,Integer>pMap=new HashMap<>();
        Map<Character,Integer>sMap=new HashMap<>();

        for(char c:p.toCharArray()){
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }

        int left=0,right=0;
        int pLength=p.length();

        while(right<s.length()){
            char c=s.charAt(right);
            sMap.put(c,sMap.getOrDefault(c,0)+1);

            if(right-left+1==pLength){
                if(sMap.equals(pMap)){
                    result.add(left);
                }
                char leftChar=s.charAt(left);
                if(sMap.get(leftChar)==1){
                    sMap.remove(leftChar);
                }
                else{
                    sMap.put(leftChar,sMap.get(leftChar)-1);
                }
                left++;
            }
            right++;
        }
        return result;*/
        int ls=s.length(),lp=p.length();
        List<Integer>result=new ArrayList<>();
        if(lp>ls)return result;
        int freq[]=new int[26];
        for(int i=0;i<lp;i++){
            freq[p.charAt(i)-'a']--;
            freq[s.charAt(i)-'a']++;
        }
        if(allZero(freq))result.add(0);
        for(int i=lp;i<ls;i++){
            freq[s.charAt(i)-'a']++;
            freq[s.charAt(i-lp)-'a']--;
            if(allZero(freq))result.add(i-lp+1);
        }
        return result;
    }
    public boolean allZero(int freq[]){
        for(int i:freq){
            if(i!=0)return false;
        }
        return true;
    }
}