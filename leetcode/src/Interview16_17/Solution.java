package Interview16_17;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        return mySolution(nums,0,nums.length - 1);

    }
    public int mySolution(int[] nums,int start,int end){
        if(start == end)
            return nums[start];
        int mid = start + (end - start) / 2;
        int l = mySolution(nums,start,mid);
        int r = mySolution(nums,mid + 1,end);
        int m = nums[mid];
        int max = m;
        for (int i = mid - 1; i >= start ; i--) {
            m += nums[i];
            if(m > max)
                max = m;
        }
        m = max;
        for (int i = mid + 1; i <= end ; i++) {
            m+=nums[i];
            if(m > max)
                max = m;
        }
        return Math.max(Math.max(l,r),max);
    }
}