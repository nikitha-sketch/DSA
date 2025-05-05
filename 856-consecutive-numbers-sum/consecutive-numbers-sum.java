class Solution {
    public int consecutiveNumbersSum(int n) {
        int cnt=0;
        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            int remainder = n - k * (k - 1) / 2;
            if (remainder % k == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}