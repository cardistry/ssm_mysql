package Interview10_05;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findString(String[] words, String s) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(words.length != 0)
                map.put(i,words[i]);
        }

    }
}