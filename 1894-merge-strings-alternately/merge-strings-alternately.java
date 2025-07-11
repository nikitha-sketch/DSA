class Solution {
    public String mergeAlternately(String word1, String word2) {
        String x = word1.toLowerCase();
        String y = word2.toLowerCase();

        // Print the lowercase words
        System.out.println(x);
        System.out.println(y);

        // Merge the words alternately
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < x.length() || i < y.length()) {
            if (i < x.length()) result.append(x.charAt(i));
            if (i < y.length()) result.append(y.charAt(i));
            ++i;
        }
        return result.toString();
    }
}