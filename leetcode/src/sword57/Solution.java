package sword57;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            if(nums[low] + nums[high] < target)
                ++low;
            else if(nums[low] + nums[high] > target)
                --high;
            else
                return new int[]{nums[low],nums[high]};
        }
        return null;
    }
}