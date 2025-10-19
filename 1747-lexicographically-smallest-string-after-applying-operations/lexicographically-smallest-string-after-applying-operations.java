class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n=s.length();
        Queue<String>queue=new LinkedList<>();
        Set<String>visited=new HashSet<>();
        String smallest=s;
        queue.offer(s);
        visited.add(s);
        while(!queue.isEmpty()){
            String cur=queue.poll();
            if(cur.compareTo(smallest)<0){
                smallest=cur;
            }
            char arr[]=cur.toCharArray();
            for(int i=1;i<arr.length;i+=2){
                int newDigit=(arr[i]-'0'+a)%10;
                arr[i]=(char)('0'+newDigit);
            }
            String added=new String(arr);
            String rotated=cur.substring(cur.length()-b)+cur.substring(0,cur.length()-b);

            if(visited.add(added))queue.offer(added);
            if(visited.add(rotated))queue.offer(rotated);
        }
        return smallest;
    }
}