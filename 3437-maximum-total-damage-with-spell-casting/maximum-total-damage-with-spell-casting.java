class Solution {
    public long maximumTotalDamage(int[] power) {
         Map<Integer, Long> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + (long) p);
        }

        List<Integer> damages = new ArrayList<>(map.keySet());
        Collections.sort(damages);
        int n = damages.size();
        if (n == 0) return 0L;

        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            int curr = damages.get(i);
            long val = map.get(curr);

            // binary search for largest index j with damages.get(j) <= curr - 3
            int lo = 0, hi = i - 1, j = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (damages.get(mid) <= curr - 3) {
                    j = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            long include = val + (j >= 0 ? dp[j] : 0L);
            long exclude = (i > 0 ? dp[i - 1] : 0L);
            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }
}