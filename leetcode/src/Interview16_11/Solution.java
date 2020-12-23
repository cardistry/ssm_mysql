package Interview16_11;

class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0)
            return new int[0];
        if(longer == shorter)
            return new int[]{k*shorter};
        int[] sum  = new int[k + 1];
        sum[0] = k * shorter;
        int step = longer - shorter;
        for (int i = 1; i <= k ; i++) {
            sum[i] = sum[i-1] + step;
        }
        return sum;
    }
}