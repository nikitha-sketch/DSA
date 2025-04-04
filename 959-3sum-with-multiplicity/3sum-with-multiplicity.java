import java.util.Arrays;

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);  // Step 1: Sort array
        int mod = 1_000_000_007;
        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            int newTarget = target - arr[i];

            while (j < k) {
                if (arr[j] + arr[k] < newTarget) {
                    j++;
                } else if (arr[j] + arr[k] > newTarget) {
                    k--;
                } else { // Found a valid triplet
                    if (arr[j] == arr[k]) { // Case: arr[j] == arr[k], count combinations
                        int pairs = (k - j + 1) * (k - j) / 2; 
                        count = (count + pairs) % mod;
                        break;
                    } else { // Case: Different numbers, count their occurrences
                        int leftCount = 1, rightCount = 1;
                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            j++;
                            leftCount++;
                        }
                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            k--;
                            rightCount++;
                        }
                        count = (count + (long) leftCount * rightCount) % mod;
                        j++;
                        k--;
                    }
                }
            }
        }
        return (int) count;
    }
}
