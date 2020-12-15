package LC62;

class Solution {
    public static void main(String[] args) {
        new Solution().uniquePaths(3,7);
    }
    public int uniquePaths(int m, int n) {
        int [] opt = new int[n];
        for (int i = 0; i < n ; i++)
            opt[i] = 1 ;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n-1; j++) {
                opt[j] += opt[j-1];
            }
        }
        return opt[n-1];
    }
}