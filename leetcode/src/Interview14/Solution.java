package Interview14;

class Solution {
    public boolean canPermutePalindrome(String s) {
        int count = 0;
        boolean record[] = new boolean[128];
        for(char c: s.toCharArray()){
            record[c] = !record[c];
        }
        for (boolean flag:record){
            if(flag){
                if(count == 1)
                    return false;
                ++count;
            }
        }
        return true;
    }
}