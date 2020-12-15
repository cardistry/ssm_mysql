package Interview81;

class Solution {
    public int waysToStep(int n) {
        int BASE = 1000000007;
        int step[] = new int[3];
        if(n == 0)
            return 0;
        step[0] = 1;
        step[1] = 1;
        step[2] = 2 ;
        for (int i = 3; i <= n ; i++) {
            int index = i % 3;
            int pre = (index+2) % 3;
            int ppre = (index+1) % 3;
            step[index] = ((step[pre] + step[ppre])% BASE + step[index])% BASE;
        }
        return step[n % 3];
    }
}