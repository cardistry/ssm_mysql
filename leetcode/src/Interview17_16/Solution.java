package Interview17_16;

public class Solution {
    public static void main(String[] args) {
        new Solution().massage(new int[]{1,2,3,1});
    }
    public int massage(int[] nums) {
        if(nums.length == 0)
            return 0;
        int [] res = new int[nums.length];
        res[0] = nums[0];
        if(nums.length == 1)
            return  nums[0];
        res[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        if(nums.length == 2)
            return res[1];
        for (int i = 2; i < nums.length; i++) {
            res[i] = res[i-1] > res[i-2] + nums[i] ? res[i-1] : res[i-2] + nums[i];
        }
        return res[res.length-1];
    }
}