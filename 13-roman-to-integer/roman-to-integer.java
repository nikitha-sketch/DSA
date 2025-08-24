class Solution {
    public int romanToInt(String s) {
        /*char list[]=s.toCharArray();
        int val=0;
        for(int i=0;i<list.length;i++){
            if(i+1<list.length){
                if(list[i]=='I' && list[i+1]=='V'){
                    val=val+4;
                    i++;
                    continue;
                }
                else if(list[i]=='I' && list[i+1]=='X'){
                    val=val+9;
                    i++;
                    continue;
                }
                else if(list[i]=='X' && list[i+1]=='L'){
                    val=val+40;
                    i++;
                    continue;
                }
                else if(list[i]=='X' && list[i+1]=='C'){
                    val=val+90;
                    i++;
                    continue;
                }
                else if(list[i]=='C' && list[i+1]=='D'){
                    val=val+400;
                    i++;
                    continue;
                }
                else if(list[i]=='C' && list[i+1]=='M'){
                    val=val+900;
                    i++;
                    continue;
                }
            }
        if(list[i]=='I'){
            val=val+1;
        }
        else if(list[i]=='V'){
            val=val+5;
        }
        else if(list[i]=='X'){
            val=val+10;
        }
        else if(list[i]=='L'){
            val=val+50;
        }
        else if(list[i]=='C'){
            val=val+100;
        }
        else if(list[i]=='D'){
            val=val+500;
        }
        else if(list[i]=='M'){
            val=val+1000;
        }
    }
    return val;*/

        Map<Character,Integer>map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char chars[]=s.toCharArray();
        int sum=0;
        int i,j;
        for(i=0,j=1;j<chars.length;i++,j++){
            if(map.get(chars[i])>=map.get(chars[j])){
                sum+=map.get(chars[i]);
            }
            else{
                sum-=map.get(chars[i]);
            }
        }
        sum+=map.get(chars[i]);
        return sum;
    }
}