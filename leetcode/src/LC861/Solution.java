package LC861;

class Solution {
    public int matrixScore(int[][] A) {
        int sum = 0;
        int row = A.length;
        if(row == 0)
            return 0;
        int col = A[0].length;
        if(col == 0)
            return 0;
        for (int i = 0; i < row; i++)
            if(A[i][0] == 0)
                for (int j = 0; j < col; j++)
                    A[i][j] ^= 1;
        for (int i = 0; i < col; i++) {
            int count = 0;
            for (int j = 0; j < row; j++)
                if(A[j][i] == 1)
                    ++count;
            count = Math.max(count,row - count);
            sum += count * Math.pow(2,col-i-1);
        }
        return sum;
    }
}