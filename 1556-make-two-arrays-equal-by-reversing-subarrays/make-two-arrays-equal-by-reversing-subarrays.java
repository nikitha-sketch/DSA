class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        /*HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:target){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:arr){
            if(!map.containsKey(num)||map.get(num)==0){
                return false;
            }
            map.put(num,map.get(num)-1);
        }
        return true;*/
        var map=new int[1001];
        for(var n:arr)map[n]++;
        for(var n:target)map[n]--;
        return Arrays.equals(map,new int[1001]);
    }
}