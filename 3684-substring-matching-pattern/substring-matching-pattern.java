import java.util.regex.Pattern;
class Solution {
    public boolean hasMatch(String s, String p) {
        String parts[]=p.split("\\*",-1);
        String regex=Pattern.quote(parts[0])+".*"+Pattern.quote(parts[1]);
        return s.matches(".*"+regex+".*");
    }
}