package Interview51;

class Solution {
    public int insertBits(int N, int M, int i, int j) {
        int bits = j - i + 1;
        N  &= ~(((1 << bits) - 1)<<i);
        return N | (M << i);
    }
}