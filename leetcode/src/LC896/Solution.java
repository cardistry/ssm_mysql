package LC896;

class Solution {
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        int i = 0;
        while (i < A.length - 1 &&  A[i] == A[i + 1])
            ++i;
        if(i == A.length - 1)
            return true;
        boolean flag = A[i+1] - A[i] > 0 ? true : false ;
        ++i;
        for (; i < len; i++) {
            if(A[i] - A[i-1] > 0 && flag || A[i] - A[i - 1] < 0 &&  !flag || A[i] - A[i-1] == 0)
                continue;
            else
                return false;
        }
        return true;
    }
}
