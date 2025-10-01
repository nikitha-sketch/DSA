class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        //return numBottles+numExchange;
        int total=numBottles;
        int empty=numBottles;
        while(empty>=numExchange){
            int newBottles=empty/numExchange;
            total+=newBottles;
            empty=newBottles+(empty%numExchange);
        }
        return total;
    }
}