package sword64;

class Solution {
    public int sumNums(int n) {
        int res = n;
        boolean a = n > 0 && ((res+=sumNums(n-1)) > 0);
        return res;
    }
}