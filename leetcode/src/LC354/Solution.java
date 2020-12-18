package LC354;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0])
                    return o1[0]-o2[0];
                else
                    return o2[1]-o1[1];
            }
        });
        int[] dp = new int[envelopes.length];
        int res = 0;
        for(int[] p:envelopes){
            int low = 0,high = res;
            while (low < high){
                int mid = low + (high - low) / 2;
                if(dp[mid] < p[1])
                    low = mid + 1;
                else
                    high = mid;
            }
            dp[low] = p[1];
            if(res == high)
                res++;
        }
        return res;
    }
}