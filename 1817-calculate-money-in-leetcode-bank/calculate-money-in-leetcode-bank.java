class Solution {
    public int totalMoney(int n) {
        int sum=0;
        int weeks=n/7;
        int days=n%7;
        for(int i=0;i<weeks;i++){
            sum+=28+i*7;
        }
        for(int i=1;i<=days;i++){
            sum+=weeks+i;
        }
        return sum;
    }
}