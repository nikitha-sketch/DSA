class Solution {
    public int minimumPairRemoval(int[] nums) {
       List<Integer>list=new ArrayList<>();
       for(int num:nums)list.add(num);

       int operations=0;
       while(!nonDecreasing(list)){
            int minSum=Integer.MAX_VALUE;
            int index=-1;
            for(int i=0;i<list.size()-1;i++){
                int sum=list.get(i)+list.get(i+1);
                if(sum<minSum){
                    minSum=sum;
                    index=i;
                }
            }
        int merged=list.get(index)+list.get(index+1);
        list.remove(index);
        list.remove(index);
        list.add(index,merged);
        operations++;
        }
        return operations;
    }

    public boolean nonDecreasing(List<Integer>list){
        for(int i=1;i<list.size();i++){
            if(list.get(i)<list.get(i-1)){
                return false;
            }
        }
        return true;
    }
}