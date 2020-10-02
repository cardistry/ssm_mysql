package sword56Ⅰ;


class Solution {
    public int[] singleNumbers(int[] nums) {
        int mask = 1;
        int a,b,r;
        a = b = r = 0;
        for(int num:nums)
            r ^= num;
        while ((mask & r) == 0)
            mask <<=1;
        for(int num:nums){
            if((num & mask) == 0)
                a ^= num;
            else
                b ^= num;
        }
        return new int[]{a,b};
    }
}