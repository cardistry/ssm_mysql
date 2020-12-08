package Interview15;

class Solution {
    public boolean oneEditAway(String first, String second) {
        int lenF = first.length();
        int lenS = second.length();
        if(lenF - lenS > 1 || lenF - lenS < - 1)
            return false;
        boolean flag = false ;
        int indexF = 0,indexS = 0;
        while (indexF < lenF && indexS < lenS){
            if(first.charAt(indexF) == second.charAt(indexS)){
                ++indexF;
                ++indexS;
            }
            else {
                if(flag){
                    return false;
                }
                flag = true;
                if(lenF == lenS){
                    ++indexF;
                    ++indexS;
                }
                else if(lenF < lenS)
                    ++lenS;
                else
                    ++lenF;

            }
        }
        return true;

    }
}