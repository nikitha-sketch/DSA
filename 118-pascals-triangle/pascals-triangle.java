class Solution {
    public List<Integer> generateRow(int rowNum) {
        List<Integer> row = new ArrayList<>();
        long ans = 1;
        row.add(1); // first element is always 1
        for (int col = 1; col <= rowNum; col++) {
            ans = ans * (rowNum - col + 1) / col;
            row.add((int) ans);
        }
        return row;
    }

    // Generate the full Pascal's Triangle with n rows
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            triangle.add(generateRow(row));
        }
        return triangle;
    }
}