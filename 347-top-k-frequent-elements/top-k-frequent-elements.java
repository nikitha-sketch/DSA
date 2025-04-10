class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>>heap=new PriorityQueue<>(
            (a,b)->Integer.compare(b.getValue(),a.getValue())
        );
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            heap.offer(entry);
        }
        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=Objects.requireNonNull(heap.poll()).getKey();
        }
        return res;
    }
}