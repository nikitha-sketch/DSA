class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }

        StringBuilder str[]=new StringBuilder[order.length()];
        for(int i=0;i<str.length;i++){
            str[i]=new StringBuilder();
        }

        StringBuilder leftOvers=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(map.containsKey(ch)){
                int idx=map.get(ch);
                str[idx].append(ch);
            }
            else{
                leftOvers.append(ch);
            }
        }
        StringBuilder result=new StringBuilder();
        for(StringBuilder bucket:str){
            result.append(bucket);
        }
        result.append(leftOvers);
        return result.toString();
    }
}