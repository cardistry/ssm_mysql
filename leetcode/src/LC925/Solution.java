package LC925;

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int Nindex,Tindex;
        Nindex = Tindex = 0;
        while (Nindex < name.length() && Tindex < typed.length()){
            if(name.charAt(Nindex) == typed.charAt(Tindex)){
                ++Nindex;
                ++Tindex;
            }
            else {
                if(Tindex > 0 &&  typed.charAt(Tindex) == typed.charAt(Tindex - 1))
                    ++Tindex;
                else
                    return false;
            }
        }
        if(Nindex == name.length() &&  Tindex == typed.length())
            return true;
        if(Nindex == name.length()){
            while (Tindex < typed.length() && typed.charAt(Tindex) == typed.charAt(Tindex - 1))
                ++Tindex;
            if(Tindex == typed.length())
                return true;
            return false;
        }
        return false;

    }
}