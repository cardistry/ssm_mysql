package sword46;

class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        return getnum(str,0,len - 1) + 1;
    }
    int getnum(String str,int begin,int end){
        if(begin >= end)
            return 0;
        int val2 = Integer.parseInt(str.substring(begin,begin + 2));
        int val1 = Integer.parseInt(str.substring(begin,begin + 1));
        if(val1 == 0)
            return getnum(str,begin+1,end);
        if(val2  < 26)
            return 1 + getnum(str,begin+2,end) + getnum(str,begin + 1,end);
        else
            return getnum(str,begin + 1,end);
    }
}