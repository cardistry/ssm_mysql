package sword57Ⅱ;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findContinuousSequence(9));
    }
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int low ,high;
        low = 1;
        high = 2;
        while (low <= high){
            int[] tmp = new int[high-low+1];
            int sum = (high - low + 1)*(low + high)/2;
            if(sum == target && low != high){
                for(int i = low; i <= high; ++i)
                    tmp[i-low] = i;
                res.add(tmp);
                low += 2;
            }
            else if(sum < target)
                ++high;
            else
                ++low;
        }
        return res.toArray(new int [res.size()][]);
    }
}