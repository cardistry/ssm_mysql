package sword47;

class Solution {

    public int maxValue(int[][] grid) {
        if(grid.length != 0 && grid[0].length != 0){
            int row = grid.length;
            int col = grid[0].length;
            //第一行
            for(int i = 1; i < row; ++i)
                grid[0][i] += grid[0][i-1];
            //第一列
            for(int i = 1; i < col; ++i)
                grid[i][0] += grid[i-1][0];

            for(int i = 1;i < row; ++i){
                for(int j = 1; j < col; ++j){
                    grid[i][j] += (grid[i-1][j] > grid[i][j-1] ? grid[i-1][j] : grid[i][j-1]);
                     }
            }
            return grid[row-1][col-1];
        }

        return 0;
    }

    int DFS(int[][] grid,int row,int col){
        int val,down,right;
        if(row >= grid.length || col >= grid[0].length)
            return 0;
        val = grid[row][col];
        if(row == grid.length - 1 && col == grid[0].length - 1)
            return val;
        down = DFS(grid,row + 1,col);
        right = DFS(grid,row,col + 1);
        return val + (down > right ? down : right);

    }
}