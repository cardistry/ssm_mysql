package Interview16_07;

class Solution {
    int maximum(int a, int b) {
        long _sum = (long)a + (long)b;
        long _diff = (long)a - (long)b;
        long _abs_diff = (_diff ^ (_diff >> 63)) - (_diff >> 63);
        return (int)((_sum + _abs_diff) / 2);
    }   //不能处理（a - b) 溢出问题


};
