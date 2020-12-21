package LC746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int pre = 0,ppre = 0,cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = Math.min(pre + cost[i - 1], ppre + cost[i - 2]);
            ppre = pre;
            pre = cur;
        }
        return cur;
    }
}

