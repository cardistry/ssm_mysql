package sword66;

class Solution {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int tmp = 1;
        for(int i = 1; i < a.length; ++i)
            res[i] = res[i-1] * a[i-1];
        for(int i = a.length - 2; i >=0;--i){
            tmp *= a[i+1];
            res[i] *= tmp;
        }
        return res;
    }
}