class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank=0,curTank=0,start=0;
        int n=gas.length;
        for(int i=0;i<n;i++){
            totalTank+=gas[i]-cost[i];
            curTank+=gas[i]-cost[i];
            if(curTank<0){
                start=i+1;
                curTank=0;
            }
        }
        return totalTank>=0?start:-1;
    }
}