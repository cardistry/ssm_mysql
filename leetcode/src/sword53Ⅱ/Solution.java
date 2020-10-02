package sword53Ⅱ;

class Solution {
    public static void main(String[] args) {
        int []nums = {0,1,3};
        Solution s = new Solution();
        System.out.println(s.missingNumber(nums));
    }
    public int missingNumber(int[] nums) {
      int left = 0;
      int right = nums.length - 1;
      while (left <= right){
          int mid = left + (right - left) /2;
          if(mid == nums[mid])
              left = mid + 1;
          else
              right = mid - 1;
      }
      return left;
    }
}