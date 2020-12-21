package Interview16_02;

import java.util.HashMap;
import java.util.Map;

class WordsFrequency {

    Map<String, Integer> bookMap = new HashMap();

    public WordsFrequency(String[] book) {
        for(String word : book){
            Integer count = get(word);
            bookMap.put(word, count+1);
        }
    }

    public int get(String word) {
        return bookMap.getOrDefault(word, 0);
    }
}


