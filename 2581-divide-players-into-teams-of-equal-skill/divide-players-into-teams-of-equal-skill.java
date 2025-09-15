class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long chemistry=0;
        int left=0;
        int right=skill.length-1;
        int sum=skill[0]+skill[right];
        while(left<right){
            if(skill[left]+skill[right]!=sum)return -1;

            chemistry+=(long)(skill[left]*skill[right]);
            left++;
            right--;
        }
        
        return chemistry;
    }
}