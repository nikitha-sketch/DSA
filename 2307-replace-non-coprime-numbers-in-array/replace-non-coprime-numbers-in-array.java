class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer>result=new ArrayList<>();
        for(int num:nums){
            result.add(num);
            while(result.size()>1){
                int a=result.get(result.size()-1);
                int b=result.get(result.size()-2);
                int g=gcd(a,b);
                if(g>1){
                    result.remove(result.size()-1);
                    result.remove(result.size()-1);

                    long lcm=(long) a*b/g;
                    result.add((int)lcm);
                }
                else{ 
                    break;
                }
            }
        }
        return result;
    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}