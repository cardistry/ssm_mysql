package Interview813;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int pileBox(int[][] box) {
        Arrays.sort(box, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int ans =  o1[2] - o2[2];
                if(ans == 0){
                    ans = o1[1] - o2[1];
                    if(ans == 0)
                        ans = o1[0] - o2[0];
                }
                return ans;
            }
        });
        int length= box.length;
        int[] dp=  new int[length];
        dp[0] = box[0][2];
        int ans = dp[0];
        for (int i = 1; i < length; i++) {
                dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if(box[j][0]<box[i][0]&&box[j][1]<box[i][1]&&box[j][2]<box[i][2])
                    dp[i] = Math.max(dp[i],dp[j] + box[i][2]);
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;


    }
}