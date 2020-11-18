package LC1207;

import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> list = new HashMap();
        for(int num :arr){
            Integer value = list.get(num);
            if(value == null)
                list.put(num,0);
            else{
                list.put(num,value+1);
            }
        }
        int len = arr.length;
        boolean record[] = new boolean[len + 1];
        Iterator iter = list.keySet().iterator();
        while (iter.hasNext()){
            int index = list.get(iter.next());
            if(record[index])
                return false;
            record[index] = true;
        }
        return true;

    }
}