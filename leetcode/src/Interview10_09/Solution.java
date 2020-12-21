package Interview10_09;

class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},
                {21,22,23,24,25}};
        System.out.println(new Solution().searchMatrix(matrix, 5));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0)
            return false;
        int col = matrix[0].length;
        if(col == 0)
            return false;

        return DFS(matrix,target,0,0,row - 1,col - 1);

    }

    public boolean DFS(int[][] matrix, int target,int srow,int scol,int erow,int ecol){
        if(srow > erow || scol > ecol)
            return false;
        int row = srow + (erow - srow) /2;
        int col = scol + (ecol - scol) /2;
        int val = matrix[row][col];

        if(val == target)
            return true;
        if(srow == erow && scol == ecol)
            return false;
        if(val > target)
            return DFS(matrix,target,srow,scol,erow,col-1) || DFS(matrix,target,srow,col,row-1,
                    ecol);
        else {
            return DFS(matrix,target,srow,col + 1,erow,ecol) ||
                    DFS(matrix,target, row + 1,scol,erow,col);
        }

    }
}