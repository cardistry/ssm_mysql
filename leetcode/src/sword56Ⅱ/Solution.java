package sword56Ⅱ;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{1,6,1,1}));
    }
    public int singleNumber(int[] nums) {
        int mask = 1;
        int count,result;
        result = 0;
        for(int i = 0; i < 30; ++i){
            count = 0;
            for(int num:nums)
                if((num & mask)!=0)
                    ++count;
            result |= mask * (count % 3);
            mask <<= 1;
        }
        return result;
    }
}