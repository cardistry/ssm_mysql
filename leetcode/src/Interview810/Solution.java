package Interview810;

class Solution {
    public static void main(String[] args) {
        int[][] img = new int[][]{{0,0,0},{0,1,1}};
        new Solution().floodFill(img,1,1,1);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(newColor == oldColor)
            return image;
        DFS(image,sr,sc,newColor,image[sr][sc],image.length,image[0].length);
        return image;
    }
    public void DFS(int[][] image, int sr, int sc, int newColor,int oldColor,int row,int col){
        int[][]dire = new int[][]{{1,0},{0,-1},{0,1},{-1,0}};
        if(sr < 0 || sc < 0 || sr >= row || sc >= col)
            return;
        if(image[sr][sc] == oldColor){
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++)
                DFS(image,sr + dire[i][0],sc + dire[i][1],newColor,oldColor,row,col);

        }
    }
}