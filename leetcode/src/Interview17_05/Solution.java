package Interview17_05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] array = new String[]{
                "A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"
        };
        new Solution().findLongestSubarray(array);
    }
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int record[] = new int[n + 1];
        Map<Integer, Integer> res = new HashMap<>();
        int max = 0;
        int from = 0,to = 0;
        for (int i = 1; i <= n; i++) {
            if (Character.isDigit(array[i-1].charAt(0)))
                record[i] = record[i - 1] + 1;
            else
                record[i] = record[i - 1] - 1;
        }
        for (int i = 1; i <= n ; i++) {
            int index = record[i];
            if(index == 0){
                if(i  > max){
                    max = i ;
                    from = 0;
                    to = i;
                }
            }
            else{
                    if(!res.containsKey(index))
                        res.put(index,i);
                    else if(i - res.get(index) > max){
                        max = i - res.get(index);
                        from = res.get(index);
                        to = i;
                    }
                }


        }
        if(max == 0)
            return new String[0];
        else
            return Arrays.copyOfRange(array,from,to);

    }
}