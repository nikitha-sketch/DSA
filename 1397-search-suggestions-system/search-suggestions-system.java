class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>>result=new ArrayList<>();
        List<String>repo=new ArrayList<>();
        for(String item:products){
            repo.add(item.toLowerCase());
        }
        Collections.sort(repo);
        searchWord=searchWord.toLowerCase();
        for(int i=1;i<=searchWord.length();i++){
            String prefix=searchWord.substring(0,i);
            List<String>suggestions=new ArrayList<>();
            for(String product:repo){
                if(product.startsWith(prefix)){
                    suggestions.add(product);
                    if(suggestions.size()==3)break;
                }
                
            }
            result.add(suggestions);
           // return result;
        }
        return result;
    }
}