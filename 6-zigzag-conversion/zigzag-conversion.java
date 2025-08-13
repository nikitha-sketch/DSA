class Solution {
    public String convert(String s, int numRows) {
          if(numRows==1 || numRows>=s.length()){
            return s;
          }
          int ind=0,d=1;//d for direction
          List<Character>[] rows=new ArrayList[numRows];
          for(int i=0;i<numRows;i++){
            rows[i]=new ArrayList<>();
          }
          for(char c:s.toCharArray()){
            rows[ind].add(c);
            if(ind==0){
                d=1;
            }else if(ind==numRows-1){
                d=-1;
            }
            ind=ind+d;
          }
          StringBuilder result=new StringBuilder();
          for(List<Character>row:rows){
            for(char c:row){
                result.append(c);
            }
          }
          return result.toString();
    }
}