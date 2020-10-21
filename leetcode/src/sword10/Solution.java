package sword10;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa","a*"));
    }
    public boolean isMatch(String s, String p) {
        int i,j;
        i = j = 0;
        while (i < s.length() && j < p.length()){
            if(s.charAt(i) == p.charAt(j)){
                ++j;
                ++i;
            }
            else {
                if(p.charAt(j) == '.'){
                    ++i;
                    ++j;
                }
                else if(p.charAt(j) == '*'){
                    if(j - 1 >= 0 && p.charAt(j-1) == '.')
                        
                    if(i - 1 >= 0 && s.charAt(i) == s.charAt(i-1)){
                        ++i;
                        ++j;
                    }
                    else
                        return false;
                }
                else {
                    if(j - 1 >= 0 && p.charAt(j-1) == '*'){
                        if(i - 1 > 0 && s.charAt(i) == s.charAt(i-1))
                            ++i;
                    }
                    if( j + 1 < p.length() && p.charAt(j+1) == '*'){
                        j+=2;
                    }
                    else
                        return false;
                }
            }
        }
        if(i == s.length() && j == p.length())
            return true;
        if(j == p.length()){
            if(s.charAt(s.length()-1) == '*'){
                while (p.charAt(j) == p.charAt(i-1))
                    ++j;
                if(j ==  s.length())
                    return true;
                return false;
            }
            return false;
        }
        return false;


    }
}