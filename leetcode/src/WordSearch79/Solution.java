package WordSearch79;

class Solution {

//
//    public static void main(String[] args) {
//        int row ,col;
//        char [][] board;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入行数");
//        row = scanner.nextInt();
//        System.out.println("请输入列数");
//        col = scanner.nextInt();
//        System.out.println("请输入字符串");
//        scanner.nextLine();
//        String s = scanner.nextLine();
//        board = new char[row][col];
//        System.out.println("请输入地图");
//        for(int i = 0;i < row ;++i){
//            String tmp = scanner.nextLine();
//            for(int j = 0; j < col ; ++j){
//                board[i][j] = tmp.charAt(j);
//            }
//        }
//        Solution solution = new Solution();
//        solution.exist(board, s);
//    }

    public boolean exist(char[][] board, String word) {
        int rownum,colnum;
        rownum = board.length;
        if(rownum > 0)
            colnum = board[0].length;
        else return false;
        if(colnum <= 0)
            return false;
        boolean [][] visited = new boolean[rownum][colnum];
        for(int i = 0;i < rownum ;++i){
            for(int j = 0; j < colnum ; ++j){
                if(DFS(board,word,i,j,0,visited))
                    return true;
            }
        }
        return false;


    }

    boolean DFS(char[][] board,String word,int row,int col,int curindex,boolean [][] visited) {

        if (board[row][col] != word.charAt(curindex))
            return false;
        else if (curindex == word.length() - 1)
            return true;
        visited[row][col] = true;

        boolean res = false;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dirs : directions) {
            int newrow = row + dirs[0];
            int newcol = col + dirs[1];
            if (newrow >= 0 && newrow < board.length && newcol >= 0 && newcol < board[0].length && !visited[newrow][newcol]) {
                if(DFS(board, word, newrow, newcol, curindex + 1, visited))
                    return true;
            }
        }
        visited[row][col] = false;
        return res;
    }

}