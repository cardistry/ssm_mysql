package Interview17_23;


public class Solution {
    public int[] findSquare(int[][] matrix) {
        int r = 0,c = 0,size = 0;
        int n = matrix.length;
        int[][] l = new int[n][n];
        int[][] h = new int[n][n];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 0){
                    l[i][j] = (j == 0 ? 1: l[i][j-1]+1);
                    h[i][j] = (i == 0 ? 1: h[i-1][j]+1);
                }
            }
        }
        for(int i = 0; i < n;++i){
            for(int j =0; j < n; ++j){
                if(matrix[i][j] == 0){
                    int len = Math.min(l[i][j],h[i][j]);
                    if(len > size){
                        for(int k = size; k < len; ++k){
                            if(h[i][j-k]>= k +1 && l[i-k][j] >= k + 1){
                                    size = k + 1;
                                    r = i - size + 1;
                                    c = j - size + 1;

                            }
                        }
                    }

                }
            }
        }
        return size == 0 ? new int[0]: new int[]{r,c,size};
    }
}