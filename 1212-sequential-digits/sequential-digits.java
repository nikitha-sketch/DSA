class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String chars="123456789";
        List<Integer>result=new ArrayList<>();

        int lLen=String.valueOf(low).length();
        int hLen=String.valueOf(high).length();

        for(int len=lLen;len<=hLen;len++){
            for(int j=0;j+len<=chars.length();j++){
                String sub=chars.substring(j,j+len);
                int num=Integer.parseInt(sub);
                if(num>=low && num<=high){
                    result.add(num);
                }
            }
        }
        return result;
    }
}