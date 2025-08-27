class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int maxlen=0;
        /*for(int i=0;i<n;i++){
            int arr[]=new int[26];
            for(int j=i;j<n;j++){
                if(++arr[s.charAt(j)-'a']==3)break;
                maxlen=Math.max(maxlen,j-i+1);
            }
        }
        return maxlen;*/
        int left=0;
        int count[]=new int[26];
        for(int right=0;right<n;right++){
            count[s.charAt(right)-'a']++;
            while(count[s.charAt(right)-'a']>2){
                count[s.charAt(left)-'a']--;
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}