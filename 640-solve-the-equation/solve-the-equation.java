class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] leftPart = evaluate(parts[0]);
        int[] rightPart = evaluate(parts[1]);

        // Check for infinite or no solutions
        if (leftPart[0] == rightPart[0] && leftPart[1] == rightPart[1]) {
            return "Infinite solutions";
        } else if (leftPart[0] == rightPart[0]) {
            return "No solution";
        }
        
        // Solve for x
        return "x=" + (rightPart[1] - leftPart[1]) / (leftPart[0] - rightPart[0]);
    }

    public int[] evaluate(String str) {
        String[] tokens = str.split("(?=[+-])");  // Split based on '+' and '-'
        int[] res = new int[2];  // res[0] = coefficient of x, res[1] = constant sum

        for (String token : tokens) {
            // Handling cases like "+x" or "x"
            if (token.equals("+x") || token.equals("x")) {
                res[0]++;  // Coefficient of x is 1
            } 
            // Handling case like "-x"
            else if (token.equals("-x")) {
                res[0]--;  // Coefficient of x is -1
            } 
            // Handling case like "2x", "-2x", "3x"
            else if (token.contains("x")) {
                if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                    res[0] += Integer.parseInt(token.substring(0, token.length() - 1));
                } else {
                    res[0] += Integer.parseInt(token.substring(0, token.length() - 1));
                }
            } 
            // Handle the constant part (numbers without "x")
            else if (!token.isEmpty()) {
                res[1] += Integer.parseInt(token);  // It's a constant term
            }
        }
        return res;
    }
}
