class Solution {
    public int largestAltitude(int[] gain) {
        int altitude=0;
        int maxAltitude=0;
        for(int gains:gain){
            altitude+=gains;
            maxAltitude=Math.max(altitude,maxAltitude);
        }
        return maxAltitude;
    }
}