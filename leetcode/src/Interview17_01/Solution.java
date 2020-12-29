package Interview17_01;

class Solution {
    public int add(int a, int b) {
        int next,sum; //进位，//本位
        next = a & b;
        sum = a ^ b;
        while (next != 0){
            a = next << 1;
            b = sum;
            next = a & b;
            sum = a ^ b;
        }
        return sum;
    }
}