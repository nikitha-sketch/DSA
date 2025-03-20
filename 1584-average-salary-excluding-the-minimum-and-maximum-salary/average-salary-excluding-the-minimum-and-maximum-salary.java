class Solution {
    public double average(int[] salary) {
        /*Arrays.sort(salary);
        int min=salary[0],max=salary[salary.length-1];
        double sum=0;
        double x=0;
        int n=salary.length-1;
        for(int i=1;i<n;i++){
            sum+=salary[i];
        }
        x=sum/(n-1);
        return x;
        */
        double s=0;
        Integer min=Integer.MAX_VALUE;
        Integer max=Integer.MIN_VALUE;
        for(int i=0;i<salary.length;i++){
            min=Math.min(min,salary[i]);
            max=Math.max(max,salary[i]);
            s+=salary[i];
        }
        s-=(min+max);
        return s/(salary.length-2);
    }
}