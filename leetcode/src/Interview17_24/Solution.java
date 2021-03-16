package Interview17_24;

class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        int max=Integer.MIN_VALUE;
        int dp=0,start=0;
        int[] ans=new int[] {-1,-1,200,200};//结果
        int[] sum=null;//纵向累加数组
        for(int i=0;i<matrix.length;i++) {
            sum=new int[matrix[0].length];
            for(int j=i;j<matrix.length;j++) {
                dp=0;start=0;
                for(int k=0;k<sum.length;k++) {
                    sum[k]+=matrix[j][k];
                    dp+=sum[k];
                    if(max<dp) {
                        ans[0]=i;ans[1]=start;
                        ans[2]=j;ans[3]=k;
                        max=dp;
                    }
                    if(dp<0) {
                        dp=0;start=k+1;
                    }
                }
            }
        }
        return ans;
    }
}