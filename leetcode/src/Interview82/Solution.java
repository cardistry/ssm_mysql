package Interview82;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Integer a = 10000;
        Solution s = new Solution();
        boolean c =  s.add(a) || s.add(a);
        System.out.println(a);



    }
    boolean add(Integer a){
        a += 10;
        return a > 200;
    }


    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row == 0)
            return res;
        int col = obstacleGrid[0].length;
        if(col == 0)
            return  res;
        if(obstacleGrid[0][0] == 1)
            return res;
        DFS(obstacleGrid,0,0,row,col);
        return res;
    }

    public boolean DFS(int[][] obstacleGrid,int i,int j,int row,int col){
        if(i == row||j == col||obstacleGrid[i][j] == 1)
            return false;
        res.add(Arrays.asList(i, j));
        if(i == row - 1 && j == col - 1)
            return true;
        boolean flag = DFS(obstacleGrid,i+1,j,row,col)||DFS(obstacleGrid,i,j+1,row,col);
        if(!flag){
            res.remove(res.size() - 1);
            obstacleGrid[i][j] = 1;
        }
        return flag;
    }
}