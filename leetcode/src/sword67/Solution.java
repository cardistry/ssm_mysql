package sword67;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strToInt("-6147483648"));
    }
    public int strToInt(String str) {
        int index,start,overflag,prenum,curnum;
        index = prenum = curnum = overflag =  0;
        int flag = 1;
        while (index < str.length() && str.charAt(index) == ' ')
            ++index;
        if(index == str.length() || (str.charAt(index) != '+' && str.charAt(index) != '-' && !Character.isDigit(str.charAt(index))))
            return 0;
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            if(str.charAt(index) == '-')
                flag = -1;
            ++index;
        }
        for(start = index;index < str.length() && Character.isDigit(str.charAt(index)) ;++index){
           int num = str.charAt(index) - 48;
            curnum = curnum * 10 + num;
            if(prenum != curnum/10) {
                overflag = 1;
                break;
            }
            prenum = curnum;
        }
        if(overflag == 1){
            if(flag  == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        return curnum*flag;


    }
}