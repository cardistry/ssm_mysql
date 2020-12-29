package Interview17_10;

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int score = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == cur)
                ++score;
            else {
                if(score > 0)
                    --score;
                else
                   cur = nums[i];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == cur)
                ++score;
            else
                --score;
        }
        if(score > 0)
            return cur;
        return -1;
    }
}