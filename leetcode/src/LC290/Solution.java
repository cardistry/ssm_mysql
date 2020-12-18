package LC290;

import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        if(pattern == null || "".equals(pattern)  || s == null || "".equals(s)) return false;
        String[] s1 = s.split(" ");
        if(pattern.length() != s1.length) return false;
        HashMap<Character,String> hashMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if(!hashMap.containsKey(key)) {
                for (String value : hashMap.values()) {
                    if(value.equals(s1[i])) {
                        return false;
                    }
                }
                hashMap.put(key,s1[i]);
            }else {
                String value = hashMap.get(key);
                if(s1[i].equals(value)) {
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}

