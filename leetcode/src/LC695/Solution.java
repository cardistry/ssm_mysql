package LC695;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<Integer>());
            }
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLength + 1);
            } else {
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}



/*
    //优化贪心算法，将贪心算法中的数组进行优化，仅仅使用三个变量存储按顺序轮询数组时前一个位置和当前位置的子序列情况，如果前一个位置和当前位置不连续，则判断前一个位置是否存在不满足条件的子序列，存在则返回false，不存在则初始化变量。如果前一个位置和当前位置连续，则判断当前位置的值是否能配平不满足条件的子序列，不能配平则返回false，可以配平则根据除配平需要的数据量外剩余数据量更新变量，轮询到数组结尾，判断是否还存在不满足条件的子序列即可
    bool isPossible(int* nums, int numsSize){
        int dp1 = 0;    //长度为1的子序列数量
        int dp2 = 0;    //长度为2的子序列数量
        int dp3 = 0;    //长度为3的子序列数量
        int i = 0;

        //轮询整个数组所有位置
        while (i < numsSize) {
            //计算当前位置值在数组中一共重复多少次
            int start = i;
            int x = nums[i];
            while (i < numsSize && nums[i] == x) {
                i++;
            }
            int cnt = i - start;

            //判断当前位置是否和前一个位置相邻
            if (start > 0 && x != nums[start - 1] + 1) {
                //如果两个位置不相邻的话，判断前一个位置的长度为1和2的序列是否存在，如果存在，说明数组有无法凑成3个的连续子序列
                if (dp1 + dp2 > 0) {
                    return false;
                    //如果前一个位置不存在长度为1和2的序列，则当前位置长度为1的序列可以产生重复数量个，长度为2和3的不存在
                } else {
                    dp1 = cnt;
                    dp2 = dp3 = 0;
                }
            } else {
                //如果两个位置相邻的话，判断前一个位置的长度为1和2的序列是否可以和当前位置的重复数量匹配，如果大于则说明存在无法配平的情况，一定会出现小于3的连续子序列
                if (dp1 + dp2 > cnt) {
                    return false;
                }
                //计算到达当前位置可以用于生成新序列和加长到长度等于3的数字量，即去掉配平长度为1和2的序列的个数，还剩下多少重复数量
                int left = cnt - (dp1 + dp2);
                //计算用于加长到长度等于3的数字量，因为加长到符合要求的优先级要大于新生成序列，所以从中取最小值进行即可
                int keep = fmin(dp3, left);
                //当前位置长度等于3的子序列量等于前一个位置长度等于2的子序列量加上用于加长序列的数字量
                dp3 = keep + dp2;
                //当前位置长度等于2的子序列量等于前一个位置长度等于1的子序列量，相当于单纯的加长
                dp2 = dp1;
                //当前位置长度等于1的子序列量等于除开配平前一个位置长度为1和2的数字量，以及加长前一个位置长度为2的数字量后，剩余用来新生成序列的数字量
                dp1 = left - keep;
            }
        }

        //轮询完毕后判断长度为1和2的子序列是否存在
        return dp1 == 0 && dp2 == 0;
    }

*/