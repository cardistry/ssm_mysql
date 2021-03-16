package Interview1708;

import java.util.Arrays;
public class Solution {
    static final int BIT = 14;
    static final int BASE = (1 << BIT) - 1;
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int N = height.length;
        for (int i = 0; i < N; i++) {
            height[i] = (height[i] << BIT) + (BASE - weight[i]);
        }
        Arrays.sort(height);
        int[] dp = new int[N];
        int R = 0;
        for (int num: height) {
            if (insert(dp, R - 1, BASE - (num & BASE)) == R) R++;
        }
        return R;
    }

    public int insert(int[] A, int R, int num) {
        if (R >= 0 && A[R] < num) {
            A[R + 1] = num;
            return R + 1;
        }
        int L = 0;
        while (L < R) {
            int mid = L + R >> 1;
            if (A[mid] < num) L = mid + 1;
            else R = mid;
        }
        A[L] = num;
        return L;
    }
}