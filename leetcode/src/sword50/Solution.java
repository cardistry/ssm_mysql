package sword50;

class Solution {
    public char firstUniqChar(String s) {
        for(int i = 0;i < s.length(); ++i){
            char ch = s.charAt(i);
            if(s.indexOf(ch)==i && s.indexOf(ch,i+1) == -1)
                return ch;
        }
        return ' ';

    }
}