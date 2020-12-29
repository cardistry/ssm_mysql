package Interview16_24;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {

        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int start = 0,end = nums.length - 1;
        while (start < end){
            int sum = nums[start] + nums[end];
            if(sum < target)
                ++start;
            else if(sum > target)
                --end;
            else{
                List list = new LinkedList();
                list.add(nums[start]);
                list.add(nums[end]);
                res.add(list);
                ++start;
                --end;

            }

        }
        return res;
    }
}