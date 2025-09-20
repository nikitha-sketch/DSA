import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        // There are 2^9 subsets of {1..9}, i.e., 512 possibilities
        for (int mask = 0; mask < (1 << 9); mask++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0, cnt = 0;

            for (int i = 0; i < 9; i++) {
                if ((mask & (1 << i)) != 0) {  // pick number (i+1)
                    list.add(i + 1);
                    sum += (i + 1);
                    cnt++;
                }
            }

            if (cnt == k && sum == n) {
                result.add(list);
            }
        }
        return result;
    }
}
