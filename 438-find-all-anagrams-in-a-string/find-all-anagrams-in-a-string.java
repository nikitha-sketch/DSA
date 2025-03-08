class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>result=new ArrayList<>();
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
        return result;
    }
}