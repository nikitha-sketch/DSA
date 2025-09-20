class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n=list1.length;
        int m=list2.length;
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        List<String>result=new ArrayList<>();
        int minsum=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            String restaurant=list2[j];
            if(map.containsKey(restaurant)){
                int sum=j+map.get(restaurant);
                if(sum<minsum){
                    result.clear();
                    result.add(restaurant);
                    minsum=sum;
                }
                else if(sum==minsum){
                    result.add(restaurant);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}