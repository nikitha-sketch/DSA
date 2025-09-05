import java.util.regex.Pattern;
class Solution {
    public boolean hasMatch(String s, String p) {
        /*String parts[]=p.split("\\*",-1);
        String regex=Pattern.quote(parts[0])+".*"+Pattern.quote(parts[1]);
        return s.matches(".*"+regex+".*");*/
        int startIndex=p.indexOf("*");
        String prefix=p.substring(0,startIndex);
        String suffix=p.substring(startIndex+1);

        if(prefix.isEmpty() && suffix.isEmpty())return true;

        for(int i=0;i+prefix.length()<=s.length();i++){
            if(s.startsWith(prefix,i)){
                int j=i+prefix.length();
                if(s.indexOf(suffix,j)!=-1){
                    return true;
                }
            }
        }
        return false;
    }
}