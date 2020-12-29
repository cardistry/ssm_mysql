package Interview16_21;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        new Solution().findSwapValues(new int[]{1,2,3},new int[]{4,5,6});
    }
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0,sum2= 0;
        for (Integer cur:array1)
            sum1 += cur;
        for(Integer cur:array2)
            sum2 +=cur;
        int delta = sum1 - sum2;
        if((delta & 1) == 1)
            return new int[0];
        delta /= 2;
        Set<Integer> s1 = new HashSet<>();
        for (Integer cur:array1)
            s1.add(cur);
        for(Integer cur:array2){
            if(s1.contains(cur + delta))
                return new int[]{cur + delta,cur};
        }

        return new int[0];


    }
}