package Interview56;

class Solution {
    public static void main(String[] args) {
        new Solution().convertInteger(29,15);
    }
    public int convertInteger(int A, int B) {
        int C = A ^ B;
        int num = 1,count = 0;
        for (int i = 0; i < 32; i++){
            if((C & num) != 0)
                ++count;
            num <<= 1;
        }
        return count;
    }
}