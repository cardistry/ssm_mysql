package Interview85;

class Solution {
    public static void main(String[] args) {
        int a  = new Solution().multiply(3,4);
        System.out.println(a);
    }
    public int multiply(int A, int B) {
        if(A == 1)
            return B;
        int res = multiply(A >>1,B << 1);
        if((A & 1) == 1)
            return res + B;
        else
            return res;
    }
}