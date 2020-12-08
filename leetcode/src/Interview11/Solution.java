package Interview11;

import java.util.HashSet;

class Solution {
    public boolean isUnique(String astr) {
        HashSet<Character> record = new HashSet<>();
        for(char c :astr.toCharArray()){
            if(record.contains(c))
                return false;
            else
                record.add(c);

        }
        return true;
    }
}