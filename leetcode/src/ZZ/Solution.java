package ZZ;

import java.util.regex.Pattern;
public  class Solution {
    public enum FormatType{
        INTEGER,
        DECIMALS
    }
    public  boolean StringIsInteger(String str){
        return Pattern.matches("^-?[1-9]\\d*$", str);
    }
    public  boolean StringIsDecimals(String str){
        return Pattern.matches("(^-)?[1-9]\\d*\\.\\d*|-0\\.\\d*[1-9]\\d*$", str);
    }
    public  boolean StringIsFraction(String str){
        return Pattern.matches("(^-)?[1-9]\\d*\\.\\d*|-0/\\d*[1-9]\\d*$", str);
    }
    public  double parseFraction(String str){
        String a = str.substring(0,str.indexOf("/"));
        String b = str.substring(a.length()+1,str.length());
        return Integer.parseInt(a) / Integer.parseInt(b);
    }
    public  double StrToVal(String str){
        if (StringIsInteger(str))
            return (double) Integer.parseInt(str);
        if(StringIsDecimals(str))
            return Double.parseDouble(str);
        if(StringIsDecimals(str))
            return parseFraction(str);
        else{
            System.out.println("Your Input is not legal");
            return Double.MIN_VALUE;

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.StrToVal("11"));
        System.out.println(solution.StrToVal("11.0"));
        System.out.println(solution.StrToVal("11/2"));
    }


}
