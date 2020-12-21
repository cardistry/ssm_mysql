package Interview16_06;

import java.util.Arrays;

class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int indexa = 0,indexb = 0,res = Integer.MIN_VALUE;
        while (indexa < a.length && indexb < b.length){
            if(a[indexa] < b[indexb])
                res = Math.max(res,a[indexa++] - b[indexb]);
            else
                res = Math.max(res,b[indexb++] - a[indexa]);
        }
        return -res;
    }
}