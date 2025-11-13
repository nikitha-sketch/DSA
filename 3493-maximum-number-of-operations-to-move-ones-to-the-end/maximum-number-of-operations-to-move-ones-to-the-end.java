class Solution {
    public int maxOperations(String s) {
        int res = 0, operations = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            operations += s.charAt(i) - '0';
            if (i > 0 && s.charAt(i) < s.charAt(i - 1)) {
                res += operations;
            }
        }
        return res;
    }
}