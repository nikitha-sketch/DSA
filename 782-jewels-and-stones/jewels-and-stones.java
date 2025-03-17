class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        /*int cnt=0;
        for(char c:stones.toCharArray()){
            if(jewels.indexOf(c)!=-1){
                cnt++;
            }
        }
        return cnt;*/
        int cnt=0;
        HashSet<Character>jewelsSet=new HashSet<>();
        for(char c:jewels.toCharArray()){
            jewelsSet.add(c);
        }
        HashSet<Character>stonesSet=new HashSet<>();
        for(char c:stones.toCharArray()){
            if(jewelsSet.contains(c)){
                cnt++;
            }
        }
        return cnt;
    }
}