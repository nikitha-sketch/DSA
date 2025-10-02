class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total=numBottles;
        int empty=numBottles;
        while (empty >= numExchange) {
            empty -= numExchange; // spend empty bottles
            empty++;              // get 1 new bottle (drink it -> empty again)
            total++;
            numExchange++;        // cost increases after each exchange
        }

        return total;
    }
}