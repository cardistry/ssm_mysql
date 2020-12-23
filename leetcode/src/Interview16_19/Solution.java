package Interview16_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        new Solution().pondSizes(new int[][]{{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}});
    }
    public int[] pondSizes(int[][] land) {
        List<Integer> res = new ArrayList<>();
        int row = land.length;
        if(row == 0)
            return new int[0];
        int col = land[0].length;
        if(col == 0)
            return new int[0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(land[i][j] == 0)
                    res.add(DFS(land,i,j));
            }
        }
        int[] result = res.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(result);
        return result;


    }
    public int DFS(int[][] land,int m,int n){
        if(m >= 0 && m <land.length && n >= 0 && n < land[0].length && land[m][n] == 0){
            int[][] dire = new int[][]{{1,0},{0,1},{1,1},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1}};
            int count = 1;
            land[m][n] = -1;
            for (int i = 0; i < 8; i++)
                    count += DFS(land,m + dire[i][0],n + dire[i][1]);
            return count;
        }
        return 0;

    }
//    public boolean valued(int[][] land,int m,int n, int row,int col){
//        return (m >= 0 && m < row && n >= 0 && n < col && land[m][n] == 0);
//    }

}