class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] maxCombo = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] part1 = maxArray(nums1, i);
            int[] part2 = maxArray(nums2, k - i);
            int[] merged = merge(part1, part2);
            if (greater(merged, 0, maxCombo, 0)) {
                maxCombo = merged;
            }
        }
        return maxCombo;
    }

    private int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j > 0 && nums.length - i + j > k && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, r = 0;
        while (i < nums1.length || j < nums2.length) {
            if (greater(nums1, i, nums2, j)) {
                res[r++] = nums1[i++];
            } else {
                res[r++] = nums2[j++];
            }
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}