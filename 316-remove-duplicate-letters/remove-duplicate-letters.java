class Solution {
    public String removeDuplicateLetters(String s) {
        /*String str=s.toLowerCase();
        Stack<Character> stack=new Stack<>();
        int lastIndex[]=new int[26];
        for(int i=0;i<str.length();i++){
            lastIndex[str.charAt(i)-'a']=i;
        }
        boolean inStack[]=new boolean[26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(inStack[ch-'a']){
                continue;
            }
            while (!stack.isEmpty() && ch < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            inStack[ch - 'a'] = true;
        }
        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();*/

        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}