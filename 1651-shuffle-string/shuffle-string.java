class Solution {
    public String restoreString(String s, int[] indices) {
       // if(s.length()!=indices)
       /* int n=indices.length;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            for(char ch:s.toCharArray())
            if(s.indexOf(ch)==indices[i]){
                str.append(s.charAt(ch));
            }
        }
        return str.toString();*/

        int n=indices.length;
        char arr[]=new char[n];
        for(int i=0;i<n;i++){
            arr[indices[i]]=s.charAt(i);
        }
        return new String(arr);
    }
}