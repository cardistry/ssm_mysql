package sword60;

class Solution {
    public double[] twoSum(int n) {
        double res[] = new double[6*n+1];
        double ans[] = new double[5*n];
        for(int i = 1; i <=6;++i)
            res[i] = 1;
        for(int row = 2;row <= n;++row){
            for(int col = 6 * row;col >= row;--col){
                res[col] = 0;
                for(int k = 1; k <=6 && col - k >=row - 1;++k)
                    res[col] += res[col-k];
            }
        }
        double base = Math.pow(6,n);
        for(int i = 1;i < res.length; ++i )
            res[i]/=base;
        for(int i = n; i <6*n; ++i){
            ans[i-n] = res[i];
        }
        return ans;

    }
}