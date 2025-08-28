class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer,Integer>cache;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new LinkedHashMap<>(capacity,0.75f,true);
    }
    
    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if(cache.size()>=capacity && !cache.containsKey(key)){
            int lrukey=cache.keySet().iterator().next();
            cache.remove(lrukey);
        }
        cache.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */