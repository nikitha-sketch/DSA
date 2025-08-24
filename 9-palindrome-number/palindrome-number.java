class Solution {
    public boolean isPalindrome(int x) {
      /*  if(x<0||(x%10==0&&x!=0))return false;
        int sum=0;
        int original=x;
        while(x>0){
            int rem=x%10;
            sum=sum*10+rem;
            x=x/10;
        }
        return sum==original?true:false;*/
        if(x<0)return false;
        String num=x+ "";
        return checkPalindrome(num);
       
    }
    public boolean checkPalindrome(String num){
        
        int left=0;
        int right=num.length()-1;
        while(left<right){
            if(num.charAt(left)!=num.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}