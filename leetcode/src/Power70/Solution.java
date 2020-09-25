package Power70;

class Solution {
    public double myPow(double x, int n) {
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;
        if(n == 0)
            return 1;
        if(n == Integer.MAX_VALUE){
            n = -(n / 2);
            x = 1 / (x*x) ;
        }
        if(n < 0)
            return myPow(1/x,-n);
        else{
            if(n % 2 == 1)
                return myPow(x*x,n/2) * x;
            else
                return myPow(x*x,n/2);
        }
    }
}