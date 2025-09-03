

class Solution {
    private static class Pair implements Comparable<Pair> {
        long sum;
        int idx; // left index of the adjacent pair (idx, idxRight)

        Pair(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }

        public int compareTo(Pair other) {
            if (this.sum != other.sum) return Long.compare(this.sum, other.sum);
            return Integer.compare(this.idx, other.idx); // leftmost tie-breaker
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long[] val = new long[n];
        int[] left = new int[n], right = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            val[i] = nums[i];
            left[i] = i - 1;
            right[i] = (i + 1 < n) ? i + 1 : -1;
            alive[i] = true;
        }

        // Count initial inversions (adjacent pairs where left > right)
        int invCount = 0;
        for (int i = 0; i < n; i++) {
            if (right[i] != -1 && val[i] > val[right[i]]) invCount++;
        }
        if (invCount == 0) return 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (right[i] != -1) {
                pq.add(new Pair(val[i] + val[right[i]], i));
            }
        }

        int operations = 0;

        // helper lambda as method substitute
        java.util.function.BiPredicate<Integer, Integer> isInv = (u, v) -> {
            if (u == null || v == null) return false;
            int uu = u, vv = v;
            return uu != -1 && vv != -1 && alive[uu] && alive[vv] && val[uu] > val[vv];
        };

        while (invCount > 0 && !pq.isEmpty()) {
            Pair p = pq.poll();
            if (p == null) break;
            int i = p.idx;

            // Validate pair is still alive and unchanged
            if (!alive[i]) continue;
            int r = right[i];
            if (r == -1) continue;
            long currentSum = val[i] + val[r];
            if (currentSum != p.sum) continue; // stale entry

            // We will merge i and r -> new value at i, remove r
            int L = left[i];
            int RR = right[r];

            // Remove inversion contributions of the three affected pairs (if any)
            if (L != -1 && isInv.test(L, i)) invCount--;
            if (isInv.test(i, r)) invCount--;
            if (RR != -1 && isInv.test(r, RR)) invCount--;

            // Merge
            val[i] = currentSum;
            alive[r] = false;
            right[i] = RR;
            if (RR != -1) left[RR] = i;

            // Add inversion contributions for new/changed pairs
            if (L != -1 && isInv.test(L, i)) invCount++;
            if (right[i] != -1 && isInv.test(i, right[i])) invCount++;

            // Push updated adjacent pairs into PQ (they may produce stale entries later; we'll ignore them then)
            if (L != -1) {
                int leftIdx = L;
                if (alive[leftIdx] && right[leftIdx] != -1) {
                    pq.add(new Pair(val[leftIdx] + val[right[leftIdx]], leftIdx));
                }
            }
            if (right[i] != -1) {
                pq.add(new Pair(val[i] + val[right[i]], i));
            }

            operations++;
        }

        return operations;
    }
}
