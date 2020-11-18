package LC1122;

import java.util.Comparator;

class Solution {
    int [] record = new int[10001];
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < 10001; i++) {
            record[i] = 10001;
        }
        for (int i = 0; i < arr2.length; i++) {
            record[arr2[i]]=i;
        }

    }

    class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if(01 <= 1000 && o2 <= 1000){
                if(record[o1] == 0 && record[o2] == 0)
                    return o1 - o2;
                else
                    return record[o1] - record[o2];
            }
            else if(o1 > 1000 && o2 > 1000)
                return o1-o2;
            else if(01 <= 1000){
                if(record[o1] == 0)
                    return o1 - o2;
                
            }
        }
    }
}

