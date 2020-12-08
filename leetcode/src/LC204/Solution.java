package LC204;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimes(10));
    }
    public int countPrimes(int n) {
        if(n < 3)
            return 0;
        int res = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n ; i++) {
            if(!flag[i]){
                ++res;
                for (int j = 2; j <= (n-1) / i; j++) {
                    flag[i*j] = true;
                }
            }
        }

        return  res;
    }

}