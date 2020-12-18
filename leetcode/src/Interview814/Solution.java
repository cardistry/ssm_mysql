package Interview814;

class Solution {
    public static void main(String[] args) {
        new Solution().countEval("1&0",0);

    }

    public int countEval(String s, int result) {
        int count = 0;
        if(s.length() == 1){
            if(s.charAt(0) - '0' == result)
                return 1;
            return 0;
        }

        char[] chars = s.toCharArray();
        char[] words = new char[chars.length/2];
        char[] digits = new char[chars.length / 2+1];
        for (int i = 0; i < chars.length; i++) {
            if((i &1) ==0)
                digits[i/2] = chars[i];
            else
                words[i/2] = chars[i];
        }
        int[][][] res = new int[digits.length][digits.length][2];
        opt(digits.length,words,digits,result,res);
        return res[0][digits.length-1][result];


    }
    void opt(int length, char[] words, char[] digits, int target, int count[][][]){
        for (int i = 0; i < length; i++) {
            int num = digits[i] - '0';
            count[i][i][num] = 1;
            count[i][i][1-num] = 0;

        }
        for (int k = 1; k < length ; k++) {
            for (int row = 0; row < length - k; row++) {
                for (int dist = 0; dist < k; dist++) {
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            int num = compute(i,j, words[row + dist]);
                            count[row][row+k][num]+=count[row][row+dist][i]*count[row+dist+1][row+k][j];
                        }
                    }
                }
            }
        }
    }

    int compute(int a,int b,char operation){
        switch (operation){
            case '&':
                return a & b;
            case '^':
                return a ^ b;
            default:
                return a | b;
        }
    }

}