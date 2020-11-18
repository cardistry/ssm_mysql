package LC463;

class Solution {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.islandPerimeter(new int[][]{{1,1}});
//    }
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0)
            return 0;
        if(grid[0].length == 0)
            return 0;
        int res = 0;
        int[][] direct = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1){
                  for(int k = 0; k < 4 ;++k){
                        boolean flag = false;
                        int row = i + direct[k][0];
                        int col = j + direct[k][1];
                        if(row == -1 || row == grid.length){
                            ++res;
                            flag = true;
                        }
                        if(col == -1 ||col == grid[0].length){
                            ++res;
                            flag = true;
                        }
                        if(!flag && grid[row][col] == 0)
                            ++res;
                    }
                }
            }
        }
        return res;
    }
}