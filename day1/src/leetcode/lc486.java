package leetcode;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class lc486 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {1,5,222,7};
        System.out.println(s.PredictTheWinner(nums));
    }

}


class Solution {
    //递归
//    public boolean PredictTheWinner(int[] nums) {
//        return opt(nums,0,nums.length - 1,1) >= 0;
//    }
//    public int  opt(int[] nums,int start ,int end,int turn) {
//        if(start == end){
//            return nums[start] * turn;
//        }
//        int startScore = nums[start] * turn + opt(nums,start + 1 ,end ,-turn);
//        int endScore = nums[end] * turn + opt(nums,start,end  - 1, -turn);
//        return max(startScore * turn,endScore * turn) * turn;
//    }
    //零和博弈思想
    public int [][] opt;
    public boolean PredictTheWinner(int[] nums) {
        int length  = nums.length;
        opt = new int[length][length];
        for(int i = 0; i < length;++i){
            for(int j = 0; j < length; ++j){
                opt[i][j] = -1;
            }
        }
        return score(nums,0,length - 1) * 2 >= sum(nums,0,length - 1) ;

    }
    public int sum(int[] nums,int start, int end) {
        int sum = 0;
        while (start <= end)
            sum += nums[start++];
        return sum;
    }

    int score(int[]nums,int start,int end) {
        if(opt[start][end] != -1)
            return opt[start][end];
        if(start == end)
            return opt[start][end] = nums[start];
        return opt[start][end] = sum(nums,start,end) - min(score(nums,start + 1,end),score(nums,start,end - 1));
    }
}