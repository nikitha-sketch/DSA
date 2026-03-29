class Solution {
    public boolean canBeEqual(String s1, String s2) {
        /*if(s1.length()!=s2.length())return false;
        int n=s1.length();
        char even1[]=new char[(s1.length()+1)/2];
        char odd1[]=new char[s1.length()/2];
        char even2[]=new char[(s2.length()+1)/2];
        char odd2[]=new char[s2.length()/2];
        int e=0,o=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                even1[e]=s1.charAt(i);
                even2[e]=s2.charAt(i);
                e++;
            }
            else{
                odd1[o]=s1.charAt(i);
                odd2[o]=s2.charAt(i);
                o++;
            }
        }
        Arrays.sort(even1);
        Arrays.sort(even2);
        Arrays.sort(odd1);
        Arrays.sort(odd2);
        return Arrays.equals(even1,even2)&&Arrays.equals(odd1,odd2);*/

        if(s1.length()!=s2.length())return false;
        int even[]=new int[26];
        int odd[]=new int[26];
        for(int i=0;i<s1.length();i++){
            if(i%2==0){
                even[s1.charAt(i)-'a']++;
                even[s2.charAt(i)-'a']--;
            }
            else{
                odd[s1.charAt(i)-'a']++;
                odd[s2.charAt(i)-'a']--;
            }
        }
        for(int i=0;i<26;i++){
            if(even[i]!=0 || odd[i]!=0)return false;
        }
        return true;
    }
}