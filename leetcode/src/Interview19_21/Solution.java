package Interview19_21;

class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        n += 2;
        int res = 0;
        int sum = (n + 1) * n / 2;
        for(int c : nums){
            sum -= c;
        }
        res = sum;
        int limit = sum / 2;
        sum = (limit + 1) * limit / 2;
        for(int c:nums){
            if(c <= limit)
                sum -= c;
        }
        return new int[]{sum ,res - sum};

    }
}