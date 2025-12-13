class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        
        List<String> order = Arrays.asList(
                "electronics",
                "grocery",
                "pharmacy",
                "restaurant"
        );
        Set<String>validBusiness=new HashSet<>(order);
        Map<String,List<String>>map=new HashMap<>();
        for(int i=0;i<code.length;i++){
            if(!isActive[i])continue;
            if(!validBusiness.contains(businessLine[i]))continue;
            if(code[i]==null || !code[i].matches("[A-Za-z0-9_]+"))continue;
            map.putIfAbsent(businessLine[i],new ArrayList<>());
            map.get(businessLine[i]).add(code[i]);
        }
        List<String>result=new ArrayList<>();
        for(String b:order){
            if(map.containsKey(b)){
                List<String>codes=map.get(b);
                Collections.sort(codes);
                result.addAll(codes);
            }
        }
        return result;
    }
}