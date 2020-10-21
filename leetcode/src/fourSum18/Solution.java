import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        new Solution().fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 4; ++i){
            if(i > 0 && nums[i]==nums[i-1])
                continue;
            for(int j  =i + 1; j <= nums.length - 3 ; ++j){
                if(j > i+1 && nums[j]==nums[j-1])
                    continue;
                int sum = nums[i] + nums[j];
                int low = j + 1;
                int high = nums.length - 1;
                if (nums[i] + nums[j] + nums[low] + nums[low  + 1] > target) break;
                if (nums[i] + nums[j] + nums[high - 1] + nums[high] < target) continue;
                while (low < high){
                    if(nums[low] + nums[high] < target - sum)
                        ++low;
                    else if(nums[low] + nums[high] > target - sum)
                        --high;
                    else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while (low < high && nums[high] == nums[--high]);
                        while (low < high && nums[low] == nums[++low]);

                    }

                }
            }
        }
        return res;
    }
}