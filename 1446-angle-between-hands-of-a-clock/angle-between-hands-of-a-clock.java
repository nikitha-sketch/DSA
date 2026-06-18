class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle=(hour%12)*30+0.5*minutes;  //hour hand moves 30degree per hour
        double minAngle=6*minutes;
        double diff=Math.abs(hourAngle-minAngle);
        double result=Math.min(diff,360-diff);
        return result;
    }
}