class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*Map<String,List<String>>map=new HashMap<>();
        for(String word:strs){
            char chars[]=word.toCharArray();
            Arrays.sort(chars);
            String sortedWord=new String(chars);

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord,new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());*/


        Map<String,List<String>>map=new HashMap<>();
        for(String word:strs){
            char arr[]=word.toCharArray();
            Arrays.sort(arr);
            String sortedWord=new String(arr);
            if(!map.containsKey(sortedWord)){
                map.put(sortedWord,new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}