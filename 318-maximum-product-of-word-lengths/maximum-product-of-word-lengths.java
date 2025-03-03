class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int masks[]=new int[n];
        int lengths[]=new int[n];
        int maxProd=0;
        for(int i=0;i<n;i++){
            int mask=0;
            for(char c:words[i].toCharArray()){
                mask|=(1<<(c-'a'));
            }
            masks[i]=mask;
            lengths[i]=words[i].length();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((masks[i]&masks[j])==0){
                    maxProd=Math.max(maxProd,lengths[i]*lengths[j]);
                }
            }
        }
        return maxProd;
    }
}