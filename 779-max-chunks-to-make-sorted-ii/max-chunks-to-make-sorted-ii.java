class Solution {
    public int maxChunksToSorted(int[] arr) {
        /*int n=arr.length;
        int sorted[]=arr.clone();
        Arrays.sort(sorted);
        int res=0;
        int maxOriginal=0;
        int maxSorted=0;
        for(int i=0;i<n;i++){
            maxOriginal=Math.max(maxOriginal,arr[i]);
            maxSorted=Math.max(maxSorted,sorted[i]);
            if(maxOriginal==maxSorted){
                res++;
            }
        }
        return res;
        here only some testcase are passed*/

        int n=arr.length;
        int sorted[]=arr.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer>freqDiff=new HashMap<>();
        int chunks=0;
        for(int i=0;i<n;i++){
            freqDiff.put(arr[i],freqDiff.getOrDefault(arr[i],0)+1);
            if(freqDiff.get(arr[i])==0)freqDiff.remove(arr[i]);
            freqDiff.put(sorted[i],freqDiff.getOrDefault(sorted[i],0)-1);
            if(freqDiff.get(sorted[i])==0)freqDiff.remove(sorted[i]);
            if(freqDiff.isEmpty()){
                chunks++;
            }
        }
        return chunks;
    }
}