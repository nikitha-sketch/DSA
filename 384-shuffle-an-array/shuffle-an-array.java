class Solution {
    private int original[];
    private int nums[];
    private Random rand;
    public Solution(int[] nums) {
        this.original=nums.clone();
        this.nums=nums.clone();
        this.rand=new Random();
    }
    
    public int[] reset() {
        nums=original.clone();
        return nums;
    }
    
    public int[] shuffle() {
        for(int i=nums.length-1;i>=0;i--){
            int j = rand.nextInt(i + 1); // Random index from 0 to i
            swap(nums, i, j);
        }
        return nums;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */