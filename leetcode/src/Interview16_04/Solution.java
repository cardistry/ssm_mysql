package Interview16_04;

class Solution {
    public String tictactoe(String[] board) {
        int n = board.length;
        int[][] chess = new int[n][n];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switch (board[i].charAt(j)){
                    case 'X':
                        chess[i][j] = 1;
                        break;
                    case 'O':

                        chess[i][j] = 2;
                        break;
                    default:
                        flag = true;
                        chess[i][j] = 0;
                }
            }

        }
        if(check(chess,1,n))
            return "X";
        if(check(chess,2,n))
            return "O";
        if(flag)
            return "Pending";
        return "Draw";
    }

    boolean check(int[][] chess, int num,int n){
        //行
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < n; j++) {
                if(chess[i][j] != num){
                    flag = false;
                    break;
                }
            }
            if(flag)
                return true;

        }
        //列
        for (int i = 0; i < n; i++) {
            flag  = true;
            for (int j = 0; j < n; j++) {
                if(chess[j][i] != num){
                    flag = false;
                    break;
                }
            }
            if(flag)
                return true;

        }
        //对角线
        for (int i = 0; i < n; i++) {
            flag = true;
            if(chess[i][i] != num){
                flag = false;
                break;
            }
        }
        if(flag)
            return true;

        for (int i = 0; i < n; i++) {
            flag = true;
            if(chess[i][n-i-1] != num){
                flag = false;
                break;
            }
        }

        return flag;
    }


}